//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} word1
 * @param {string} word2
 * @return {string}
 */
var mergeAlternately = function (word1, word2) {
    let res = "";
    let i = 0;
    let j = 0;
    while (i < word1.length && j < word2.length) {
        res += word1.charAt(i++);
        res += word2.charAt(j++);
    }
    if (i < word1.length) {
        res += word1.substring(i);
    }
    if (j < word2.length) {
        res += word2.substring(j);
    }
    return res;
};
//leetcode submit region end(Prohibit modification and deletion)
