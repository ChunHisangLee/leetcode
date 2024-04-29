//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[][]} grid
 * @return {number}
 */
var minFallingPathSum = function (grid) {
    const n = grid.length;

    for (let i = 1; i < n; i++) {
        let min1 = Infinity;
        let min2 = Infinity;

        for (let j = 0; j < n; j++) {
            const value = grid[i - 1][j];

            if (value < min1) {
                min2 = min1;
                min1 = value;
            } else if (value < min2) {
                min2 = value;
            }
        }

        for (let j = 0; j < n; j++) {
            if (grid[i - 1][j] == min1) {
                grid[i][j] += min2;
            } else {
                grid[i][j] += min1;
            }
        }
    }

    let minSum = Infinity;

    for (let i = 0; i < n; i++) {
        minSum = Math.min(minSum, grid[n - 1][i]);
    }

    return minSum;
};
//leetcode submit region end(Prohibit modification and deletion)
