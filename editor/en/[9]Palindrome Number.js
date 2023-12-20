//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function (x) {
    if (x < 0 || (x % 10 === 0 && x !== 0)) {
        return false;
    }
    let res = 0;
    let num = x;
    while (x !== 0) {
        res = res * 10 + x % 10;
        x = Math.floor(x / 10);
    }
    return res === num;
};
//leetcode submit region end(Prohibit modification and deletion)
