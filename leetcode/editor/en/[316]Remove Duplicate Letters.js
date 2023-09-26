//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicateLetters = function (s) {
    let stack = [];
    let set = new Set();
    let arr = new Array(26).fill(-1);

    for (let i = 0; i < s.length; i++) {
        arr[s.charCodeAt(i) - 'a'.charCodeAt(0)] = i;
    }

    for (let i = 0; i < s.length; i++) {
        let c = s[i];
        if (!set.has(c)) {
            while (stack.length && c < stack[stack.length - 1] &&
            i < arr[stack[stack.length - 1].charCodeAt(0) - 'a'.charCodeAt(0)]) {
                set.delete(stack.pop());
            }
            set.add(c);
            stack.push(c);
        }
    }

    return stack.join('');
};
//leetcode submit region end(Prohibit modification and deletion)
