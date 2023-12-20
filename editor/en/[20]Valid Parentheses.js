//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
    const stack = [];
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        if (c === '(' || c === '[' || c === '{') {
            stack.push(c);
        } else {
            if (stack.length === 0) {
                return false;
            } else {
                const top = stack.pop();
                if ((top === '(' && c !== ')') ||
                    (top === '[' && c !== ']') ||
                    (top === '{' && c !== '}')) {
                    return false;
                }
            }
        }
    }
    return stack.length === 0;
};
//leetcode submit region end(Prohibit modification and deletion)
