//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string[]} words
 * @return {number}
 */
var longestStrChain = function (words) {
    let dp = new Map();
    let maxLength = 1;

    words.sort((a, b) => a.length - b.length);

    for (const word of words) {
        let currLength = 1;

        for (let i = 0; i < word.length; i++) {
            const newWord = word.substring(0, i) + word.substring(i + 1);

            if (dp.has(newWord)) {
                currLength = Math.max(currLength, dp.get(newWord) + 1);
            }
        }

        dp.set(word, currLength);
        maxLength = Math.max(maxLength, currLength);
    }

    return maxLength;
};
//leetcode submit region end(Prohibit modification and deletion)
