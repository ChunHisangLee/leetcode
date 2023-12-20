
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumOperations(String num) {
        int n = num.length();
        int minOperations = n;  // Initialize with the maximum possible number of operations

        // Count the occurrences of each digit in the number
        int[] count = new int[10];
        for (char c : num.toCharArray()) {
            count[c - '0']++;
        }

        // Check for each possible last two digits (00, 25, 50, 75)
        for (int tens : new int[]{0, 2, 5, 7}) {
            for (int ones : new int[]{0, 5}) {
                if (tens == ones && count[tens] < 2) {
                    continue;  // Skip if not enough occurrences for the same tens and ones digit
                }
                if (count[tens] == 0 || count[ones] == 0) {
                    continue;  // Skip if tens or ones digit is not present
                }

                // Count the number of operations needed for this pair of last two digits
                int operations = n - 2;  // We need to keep the last two digits
                for (int i = 0; i <= 9; i++) {
                    operations -= Math.min(count[i], num.lastIndexOf(Integer.toString(i)) - operations);
                }

                // Update the minimum number of operations
                minOperations = Math.min(minOperations, operations);
            }
        }

        return minOperations;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
