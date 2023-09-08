
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var rearrangeString = function (s, k) {
    if (k <= 1) {
        return s;
    }
    const map = new Map();
    for (const c of s) {
        map.set(c, (map.get(c) || 0) + 1);
    }
    const maxHeap = Array.from(map.entries()).sort((a, b) => b[1] - a[1]);
    const res = [];
    const waitQueue = [];
    while (maxHeap.length > 0) {
        const curr = maxHeap.shift();
        res.push(curr[0]);
        curr[1]--;
        waitQueue.push(curr);
        if (waitQueue.length < k) {
            continue;
        }
        const front = waitQueue.shift();
        if (front[1] > 0) {
            maxHeap.push(front);
            maxHeap.sort((a, b) => b[1] - a[1]);
        }
    }
    return res.length === s.length ? res.join('') : '';
};
//leetcode submit region end(Prohibit modification and deletion)
