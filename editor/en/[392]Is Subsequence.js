//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function (s, t) {
    let i = 0;
    let j = 0;

    while (i < s.length && j < t.length) {
        if (s[i] == t[j]) {
            i++;
        }
        j++;
    }

    return i === s.length;
};
//leetcode submit region end(Prohibit modification and deletion)
