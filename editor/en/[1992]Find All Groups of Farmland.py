# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        m = len(land)
        n = len(land[0])
        farmlands = []

        def dfs(i, j):
            nonlocal min_row, min_col, max_row, max_col
            if i < 0 or i >= m or j < 0 or j >= n or land[i][j] != 1:
                return

            land[i][j] = 0
            min_row = min(min_row, i)
            min_col = min(min_col, j)
            max_row = max(max_row, i)
            max_col = max(max_col, j)

            dfs(i - 1, j)
            dfs(i + 1, j)
            dfs(i, j - 1)
            dfs(i, j + 1)

        for i in range(m):
            for j in range(n):
                if land[i][j] == 1:
                    min_row, min_col, max_row, max_col = i, j, i, j
                    dfs(i, j)
                    farmlands.append([min_row, min_col, max_row, max_col])

        return farmlands

# leetcode submit region end(Prohibit modification and deletion)
