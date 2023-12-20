//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function (numRows) {
    let res = new Array(numRows);
    for (let i = 0; i < numRows; i++) {
        res[i] = new Array();
        for (let j = 0; j <= i; j++) {
            if (j === 0 || j === i) {
                res[i][j] = 1;
            } else {
                res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
            }
        }
    }
    return res;
};
//leetcode submit region end(Prohibit modification and deletion)
