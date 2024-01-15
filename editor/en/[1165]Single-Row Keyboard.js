//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} keyboard
 * @param {string} word
 * @return {number}
 */
var calculateTime = function (keyboard, word) {
    let charToIndexMap = new Map();

    for (let i = 0; i < keyboard.length; i++) {
        charToIndexMap.set(keyboard[i], i);
    }

    let time = 0;
    let prevIndex = 0;

    for (let c of word) {
        const currIndex = charToIndexMap.get(c);
        time += Math.abs(currIndex - prevIndex);
        prevIndex = currIndex;
    }

    return time;
};
//leetcode submit region end(Prohibit modification and deletion)
