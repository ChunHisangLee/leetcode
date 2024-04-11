//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {string}
 */
var minRemoveToMakeValid = function (s) {
    let stack = [];
    let sb = s.split('');

    for (let i = 0; i < s.length; i++) {
        if (sb[i] === '(') {
            stack.push(i);
        } else if (sb[i] === ')') {
            if (stack.length) {
                stack.pop();
            } else {
                sb[i] = '*';
            }
        }
    }

    while (stack.length) {
        sb[stack.pop()] = '*';
    }

    return sb.join('').replace(/\*/g, "");
};
//leetcode submit region end(Prohibit modification and deletion)
