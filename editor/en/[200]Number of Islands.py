# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        m = len(grid)
        n = len(grid[0])

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    self.dfs(grid, i, j)

        return count

    def dfs(self, grid, i, j):
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] == '0':
            return

        grid[i][j] = '0'
        self.dfs(grid, i + 1, j)
        self.dfs(grid, i - 1, j)
        self.dfs(grid, i, j + 1)
        self.dfs(grid, i, j - 1)

# leetcode submit region end(Prohibit modification and deletion)
