//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var decodeAtIndex = function (s, k) {
    let size = 0;
    let i = 0;

    while (size < k) {
        if (!isNaN(s[i])) {
            size *= Number(s[i]);
        } else {
            size++;
        }

        i++;
    }

    for (let j = i - 1; j >= 0; j--) {
        k %= size;
        if (!isNaN(s[j])) {
            size /= Number(s[j]);
        } else {
            if (k === 0 || k === size) {
                return s[j];
            }

            size--;
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)
