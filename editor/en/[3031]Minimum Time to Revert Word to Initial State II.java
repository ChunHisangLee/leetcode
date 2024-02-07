//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int len = 0;
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            while (len > 0 && word.charAt(i) != word.charAt(len)) {
                len = dp[len - 1];
            }

            dp[i] = len + (word.charAt(i) == word.charAt(len) ? 1 : 0);
            len = dp[i];
        }

        while (len > 0 && (n - len) % k > 0) {
            len = dp[len - 1];
        }

        return (n - len + k - 1) / k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
