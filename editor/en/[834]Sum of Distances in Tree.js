//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number[]}
 */
var sumOfDistancesInTree = function (n, edges) {
    const graph = new Array(n).fill(0).map(() => []);
    const subtreeSize = new Array(n).fill(1);
    const distanceSum = new Array(n).fill(0);

    for (const [a, b] of edges) {
        graph[a].push(b);
        graph[b].push(a);
    }

    function dfs(node, parent) {
        for (const child of graph[node]) {
            if (child !== parent) {
                dfs(child, node);
                subtreeSize[node] += subtreeSize[child];
                distanceSum[node] += distanceSum[child] + subtreeSize[child];
            }
        }
    }

    function reroot(node, parent) {
        for (const child of graph[node]) {
            if (child !== parent) {
                distanceSum[child] = distanceSum[node] - subtreeSize[child] + (n - subtreeSize[child]);
                reroot(child, node);
            }
        }
    }

    dfs(0, -1);
    reroot(0, -1);
    return distanceSum;
};
//leetcode submit region end(Prohibit modification and deletion)
