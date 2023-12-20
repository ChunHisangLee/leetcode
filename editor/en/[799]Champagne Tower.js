//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} poured
 * @param {number} query_row
 * @param {number} query_glass
 * @return {number}
 */
var champagneTower = function (poured, query_row, query_glass) {
    let arr = [poured];

    for (let i = 0; i < query_row; i++) {
        let nextArr = new Array(query_row + 1).fill(0);

        for (let j = 0; j <= i; j++) {
            let temp = (arr[j] - 1) / 2;

            if (temp > 0) {
                nextArr[j] += temp;
                nextArr[j + 1] += temp;
            }
        }
        arr = nextArr;
    }

    return Math.min(1, arr[query_glass]);
};
//leetcode submit region end(Prohibit modification and deletion)
