//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} word
 * @return {number}
 */
var wonderfulSubstrings = function (word) {
    const count = new Array(1024).fill(0);
    let result = 0;
    let curr = 0;
    const n = word.length;
    count[0] = 1;

    for (let i = 0; i < n; i++) {
        curr ^= 1 << (word.charCodeAt(i) - 'a'.charCodeAt(0));
        result += count[curr];

        for (let j = 0; j < 10; j++) {
            result += count[curr ^ (1 << j)];
        }

        count[curr]++;
    }

    return result;
};
//leetcode submit region end(Prohibit modification and deletion)
