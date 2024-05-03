//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @param {string[]} dictionary
 * @return {string}
 */
var findLongestWord = function (s, dictionary) {
    dictionary.sort();
    let longestWord = "";

    function isSubsequence(word, s) {
        let wordIndex = 0;
        let sIndex = 0;

        while (wordIndex < word.length && sIndex < s.length) {
            if (word[wordIndex] === s[sIndex]) {
                wordIndex++;
            }
            sIndex++;
        }

        return wordIndex === word.length;
    }

    for (const word of dictionary) {
        if (isSubsequence(word, s)) {
            if (word.length > longestWord.length) {
                longestWord = word;
            }
        }
    }

    return longestWord;
};
//leetcode submit region end(Prohibit modification and deletion)
