//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {number}
 */
var minDeletions = function (s) {
    let freq = {};
    for (const c of s) {
        freq[c] = (freq[c] || 0) + 1;
    }
    let set = new Set();
    let res = 0;
    for (let num of Object.values(freq)) {
        let curr = num;
        while (curr > 0) {
            if (!set.has(curr)) {
                set.add(curr);
                break;
            }
            curr--;
            res++;
        }
    }
    return res;
};
//leetcode submit region end(Prohibit modification and deletion)
