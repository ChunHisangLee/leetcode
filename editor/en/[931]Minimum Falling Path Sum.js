//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function (matrix) {
    let n = matrix.length;
    for (let row = 1; row < n; row++) {
        for (let col = 0; col < n; col++) {
            let min = matrix[row - 1][col];

            if (col > 0) {
                min = Math.min(min, matrix[row - 1][col - 1]);
            }

            if (col < n - 1) {
                min = Math.min(min, matrix[row - 1][col + 1]);
            }

            matrix[row][col] += min;
        }
    }

    return Math.min(...matrix[n - 1]);
};
//leetcode submit region end(Prohibit modification and deletion)
