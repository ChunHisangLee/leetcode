//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} n
 * @param {number[]} ranges
 * @return {number}
 */
var minTaps = function (n, ranges) {
    let interval = new Array(ranges.length).fill(0);
    for (let i = 0; i < ranges.length; i++) {
        let left = Math.max(0, i - ranges[i]);
        let right = i + ranges[i];
        interval[left] = Math.max(interval[left], right);
    }

    let currEnd = 0;
    let nextEnd = 0;
    let res = 0;
    for (let i = 0; i <= n; i++) {
        if (i > nextEnd) {
            return -1;
        }
        if (i > currEnd) {
            res++;
            currEnd = nextEnd;
        }
        nextEnd = Math.max(nextEnd, interval[i]);
    }
    return res;
};
//leetcode submit region end(Prohibit modification and deletion)
