//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[][]} heights
 * @return {number}
 */
var minimumEffortPath = function (heights) {
    const dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    const m = heights.length;
    const n = heights[0].length;
    const isVisited = Array.from({length: m}, () => Array(n).fill(false));
    const arrs = Array.from({length: m}, () => Array(n).fill(Infinity));
    const pq = new MinPriorityQueue();

    arrs[0][0] = 0;
    pq.enqueue({row: 0, col: 0, nextEffort: 0}, 0);

    while (!pq.isEmpty()) {
        const curr = pq.dequeue().element;
        const i = curr.row;
        const j = curr.col;
        isVisited[i][j] = true;

        if (i === m - 1 && j === n - 1) {
            return curr.nextEffort;
        }

        for (const [dx, dy] of dirs) {
            const x = i + dx;
            const y = j + dy;

            if (x < 0 || x >= m || y < 0 || y >= n || isVisited[x][y]) {
                continue;
            }

            const diff = Math.abs(heights[x][y] - heights[i][j]);
            const max = Math.max(diff, curr.nextEffort);

            if (max < arrs[x][y]) {
                arrs[x][y] = max;
                pq.enqueue({row: x, col: y, nextEffort: max}, max);
            }
        }
    }

    return -1;
};
//leetcode submit region end(Prohibit modification and deletion)
