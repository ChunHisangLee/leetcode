//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number[]}
 */
var findMinHeightTrees = function (n, edges) {
    if (n === 1) {
        return [0];
    }

    const graph = new Array(n).fill(0).map(() => []);
    const degree = new Array(n).fill(0);

    for (const [u, v] of edges) {
        graph[u].push(v);
        graph[v].push(u);
        degree[u]++;
        degree[v]++;
    }

    const leaves = [];

    for (let i = 0; i < n; i++) {
        if (degree[i] === 1) {
            leaves.push(i);
        }
    }

    let remainingNode = n;

    while (remainingNode > 2) {
        const size = leaves.length;
        remainingNode -= size;

        for (let i = 0; i < size; i++) {
            const leaf = leaves.shift();

            for (const neighbor of graph[leaf]) {
                degree[neighbor]--;

                if (degree[neighbor] === 1) {
                    leaves.push(neighbor);
                }
            }
        }
    }

    return leaves;
};
//leetcode submit region end(Prohibit modification and deletion)
