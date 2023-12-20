//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[][]} mat
 * @param {number} k
 * @return {number[]}
 */
var kWeakestRows = function (mat, k) {
    for (let i = 0; i < mat.length; i++) {
        const sum = mat[i].reduce((a, b) => a + b);
        mat[i] = [sum, i];
    }

    mat.sort((a, b) => a[0] - b[0]);
    return mat.map((e) => e[1]).slice(0, k);
};
//leetcode submit region end(Prohibit modification and deletion)
