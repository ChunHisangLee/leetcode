//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function (s) {
    const word = s.trim().split(/\s+/);
    return word.reverse().join(' ');
};
//leetcode submit region end(Prohibit modification and deletion)
