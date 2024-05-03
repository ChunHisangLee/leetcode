# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def tribonacci(self, n: int) -> int:
        if n <= 2:
            return 0 if n == 0 else 1

        t0 = 0
        t1 = 1
        t2 = 1
        curr = 0

        for _ in range(3, n + 1):
            curr = t0 + t1 + t2
            t0 = t1
            t1 = t2
            t2 = curr

        return curr
# leetcode submit region end(Prohibit modification and deletion)
