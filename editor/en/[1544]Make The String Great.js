//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {string}
 */
var makeGood = function (s) {
    const stack = []

    for (let char of s) {
        const topChar = stack[stack.length - 1];

        if (stack.length && char.toLowerCase() === topChar.toLowerCase() && char !== topChar) {
            stack.pop();
        } else {
            stack.push(char);
        }
    }

    return stack.join('');
};
//leetcode submit region end(Prohibit modification and deletion)
