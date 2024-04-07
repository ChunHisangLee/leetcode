//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {boolean}
 */
var checkValidString = function (s) {
    let left = 0;
    let right = 0;

    for (let c of s) {
        if (c === '(') {
            left++;
            right++;
        } else if (c === ')') {
            if (left > 0) {
                left--;
            }
            right--;
        } else {
            if (left > 0) {
                left--;
            }
            right++;
        }

        if (right < 0) {
            return false;
        }
    }

    return left === 0;
};
//leetcode submit region end(Prohibit modification and deletion)
