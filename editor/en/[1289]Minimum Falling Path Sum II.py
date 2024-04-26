# leetcode submit region begin(Prohibit modification and deletion)
import heapq


class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        n = len(grid)

        for i in range(1, n):
            two_smallest = heapq.nsmallest(2, grid[i - 1])

            for j in range(n):
                grid[i][j] += two_smallest[1] if grid[i - 1][j] == two_smallest[0] else two_smallest[0]

        return min(grid[-1])
    # leetcode submit region end(Prohibit modification and deletion)
