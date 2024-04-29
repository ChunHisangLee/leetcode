# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def checkValidString(self, s: str) -> bool:
        left = 0
        right = 0

        for c in s:
            if c == '(':
                left += 1
                right += 1
            elif c == ')':
                if left > 0:
                    left -= 1
                right -= 1
            else:
                if left > 0:
                    left -= 1
                right += 1

            if right < 0:
                return False

        return left == 0
# leetcode submit region end(Prohibit modification and deletion)
