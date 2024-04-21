//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[][]} land
 * @param {number} row
 * @param {number} col
 * @param {number} m
 * @param {number} n
 * @param {Object} bounds
 */
function dfs(land, row, col, m, n, bounds) {
    if (row < 0 || row >= m || col < 0 || col >= n || land[row][col] !== 1) {
        return;
    }

    land[row][col] = 0; // Mark the cell as visited
    bounds.minRow = Math.min(bounds.minRow, row);
    bounds.maxRow = Math.max(bounds.maxRow, row);
    bounds.minCol = Math.min(bounds.minCol, col);
    bounds.maxCol = Math.max(bounds.maxCol, col);

    // Expand in all four directions
    dfs(land, row - 1, col, m, n, bounds);
    dfs(land, row + 1, col, m, n, bounds);
    dfs(land, row, col - 1, m, n, bounds);
    dfs(land, row, col + 1, m, n, bounds);
}

/**
 * @param {number[][]} land
 * @return {number[][]}
 */
var findFarmland = function (land) {
    const m = land.length;
    const n = land[0].length;
    const farmlands = [];

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (land[i][j] === 1) {
                const bounds = {minRow: i, maxRow: i, minCol: j, maxCol: j};
                dfs(land, i, j, m, n, bounds);
                farmlands.push([bounds.minRow, bounds.minCol, bounds.maxRow, bounds.maxCol]);
            }
        }
    }

    return farmlands;
};

//leetcode submit region end(Prohibit modification and deletion)
