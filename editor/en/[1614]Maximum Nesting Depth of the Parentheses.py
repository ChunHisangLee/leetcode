# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxDepth(self, s: str) -> int:
        current = 0
        max_length = 0

        for c in s:
            if c == '(':
                current += 1
                max_length = max(max_length, current)
            elif c == ')':
                current -= 1

        return max_length
# leetcode submit region end(Prohibit modification and deletion)
