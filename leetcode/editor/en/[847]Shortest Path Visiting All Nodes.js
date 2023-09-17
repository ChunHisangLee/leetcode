//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[][]} graph
 * @return {number}
 */
var shortestPathLength = function (graph) {
    const n = graph.length;

    if (n === 1) {
        return 0;
    }

    const target = (1 << n) - 1;
    const dq = [];
    const dp = Array.from({length: n}, () => Array(target + 1).fill(false));
    let res = 0;
    let min = Number.MAX_SAFE_INTEGER;

    for (const list of graph) {
        min = Math.min(min, list.length);
    }

    for (let i = 0; i < n; i++) {
        if (graph[i].length === min) {
            dq.push([i, 1 << i]);
            dp[i][i << i] = true;
        }
    }

    while (dq.length > 0) {
        const size = dq.length;

        for (let i = 0; i < size; i++) {
            const curr = dq.shift();

            for (const next of graph[curr[0]]) {
                const newVal = curr[1] | (1 << next);

                if (newVal === target) {
                    return res + 1;
                }

                if (!dp[next][newVal]) {
                    dq.push([next, newVal]);
                    dp[next][newVal] = true;
                }
            }
        }

        res++;
    }

    return -1;
};
//leetcode submit region end(Prohibit modification and deletion)
