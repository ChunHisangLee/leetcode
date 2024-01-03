//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string[]} bank
 * @return {number}
 */
var numberOfBeams = function (bank) {
    let prev = 0;
    let total = 0;

    for (let row of bank) {
        let curr = getCount(row);

        if (curr === 0) {
            continue;
        }

        total += curr * prev;
        prev = curr;
    }

    return total;

    function getCount(s) {
        let count = 0;

        for (let c of s) {
            count += parseInt(c);
        }

        return count;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
