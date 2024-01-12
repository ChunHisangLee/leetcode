//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {boolean}
 */
var halvesAreAlike = function (s) {
    const mid = s.length / 2;
    const vowels = new Set(['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']);
    const getCount = (str, vowels) => {

        let count = 0;
        for (const c of str) {
            if (vowels.has(c)) {
                count++;
            }
        }

        return count;
    }

    const first = getCount(s.substring(0, mid), vowels);
    const second = getCount(s.substring(mid), vowels);
    return first === second;
};
//leetcode submit region end(Prohibit modification and deletion)
