//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} n
 * @return {number}
 */
var tribonacci = function (n) {
    if (n <= 2) {
        return n == 0 ? 0 : 1;
    }

    let t0 = 0;
    let t1 = 1;
    let t2 = 1;
    let curr = 0;

    for (let i = 3; i <= n; i++) {
        curr = t0 + t1 + t2;
        t0 = t1;
        t1 = t2;
        t2 = curr;
    }

    return curr;
};
//leetcode submit region end(Prohibit modification and deletion)
