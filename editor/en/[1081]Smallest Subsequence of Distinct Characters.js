//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {string}
 */
var smallestSubsequence = function (s) {
    let stack = [];
    let set = new Set();
    let map = new Map();

    for (let i = 0; i < s.length; i++) {
        map.set(s[i], i);
    }

    for (let i = 0; i < s.length; i++) {
        let c = s[i];
        if (!set.has(c)) {
            while (stack.length && c < stack[stack.length - 1]
            && i < map.get(stack[stack.length - 1])) {
                set.delete(stack.pop());
            }
            set.add(c);
            stack.push(c);
        }
    }

    return stack.join('');
};
//leetcode submit region end(Prohibit modification and deletion)
