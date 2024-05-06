# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reverseWords(self, s: str) -> str:
        words = s.strip().split()
        words.reverse()
        return ' '.join(words)
# leetcode submit region end(Prohibit modification and deletion)
