
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[][]} pairs
 * @return {number}
 */
var findLongestChain = function (pairs) {
    pairs.sort((a, b) => a[1] - b[1]);
    let curr = -Infinity;
    let count = 0;
    for (const [start, end] of pairs) {
        if (curr < start) {
            count++;
            curr = end;
        }
    }
    return count;
};
//leetcode submit region end(Prohibit modification and deletion)
