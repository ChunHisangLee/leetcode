
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minimumSteps(String s) {
        long zeroCount = 0;
        long totalSwaps = 0;
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            char current = s.charAt(i);

            if (current == '0') {
                zeroCount++;
            } else if (current == '1') {
                totalSwaps += zeroCount;
            }
        }

        return totalSwaps;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
