//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return dyP(s, new HashSet<>(wordDict), dp, 0);
    }

    public boolean dyP(String s, Set<String> set, Boolean[] dp, int left) {
        if (left == s.length()) {
            return true;
        }
        if (dp[left] != null) {
            return dp[left];
        }
        for (int right = left + 1; right <= s.length(); right++) {
            if (set.contains(s.substring(left, right)) && dyP(s, set, dp, right)) {
                return dp[left] = true;
            }
        }
        return dp[left] = false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//https://blog.jiebu-lang.com/leetcode-139-word-break/