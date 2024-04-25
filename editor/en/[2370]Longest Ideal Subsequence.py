# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestIdealString(self, s: str, k: int) -> int:
        dp = [0] * 128

        for char in s:
            c = ord(char)
            dp[c] = max(dp[c - k:c + k + 1]) + 1

        return max(dp)
# leetcode submit region end(Prohibit modification and deletion)
