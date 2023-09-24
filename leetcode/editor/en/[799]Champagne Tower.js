//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} poured
 * @param {number} query_row
 * @param {number} query_glass
 * @return {number}
 */
var champagneTower = function (poured, query_row, query_glass) {
    let arrs = Array.from({length: query_row + 1}, () => new Array(query_row + 1).fill(0));

    arrs[0][0] = poured;

    for (let i = 0; i < query_row; i++) {
        for (let j = 0; j <= i; j++) {
            let temp = (arrs[i][j] - 1.0) / 2.0;

            if (temp > 0) {
                arrs[i + 1][j] += temp;
                arrs[i + 1][j + 1] += temp;
            }
        }
    }

    return Math.min(1, arrs[query_row][query_glass]);
};
//leetcode submit region end(Prohibit modification and deletion)
