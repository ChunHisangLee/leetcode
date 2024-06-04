//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)]++;
        }

        int count = 0;

        for (int num : arr) {
            count += num / 2 * 2;

            if (count % 2 == 0 && num % 2 == 1) {
                count++;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
