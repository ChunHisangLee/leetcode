//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} colors
 * @return {boolean}
 */
var winnerOfGame = function (colors) {
    let countA = 0;
    let countB = 0;

    for (let i = 2; i < colors.length; i++) {
        if (colors[i] === 'A' && colors[i - 1] === 'A' && colors[i - 2] === 'A') {
            countA++;
        }

        if (colors[i] === 'B' && colors[i - 1] === 'B' && colors[i - 2] === 'B') {
            countB++;
        }
    }

    return countA > countB;
};
//leetcode submit region end(Prohibit modification and deletion)
