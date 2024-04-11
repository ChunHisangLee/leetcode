# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def climbStairs(self, n: int) -> int:
        previous = 1
        current = 1

        for _ in range(n - 1):
            previous, current = current, previous + current

        return current

# leetcode submit region end(Prohibit modification and deletion)
