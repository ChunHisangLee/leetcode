//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {number}
 */
var minDeletions = function (s) {
    let freq = {};
    let set = new Set();
    let result = 0;

    for (const c of s) {
        freq[c] = (freq[c] || 0) + 1;
    }

    for (let num of Object.values(freq)) {
        let curr = num;

        while (curr > 0) {
            if (!set.has(curr)) {
                set.add(curr);
                break;
            }

            curr--;
            result++;
        }
    }

    return result;
};
//leetcode submit region end(Prohibit modification and deletion)
