//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} n
 * @param {number[][]} relations
 * @return {number}
 */
var minimumSemesters = function (n, relations) {
    const inDegree = new Array(n + 1).fill(0);
    const graph = Array.from({length: n + 1}, () => []);

    for (const [prev, next] of relations) {
        graph[prev].push(next);
        inDegree[next]++;
    }

    const queue = [];
    let count = 0;

    for (let i = 1; i <= n; i++) {
        if (inDegree[i] === 0) {
            queue.push(i);
            count++;
        }
    }

    let res = 0;

    while (queue.length) {
        const size = queue.length;
        res++;

        for (let i = 0; i < size; i++) {
            const current = queue.shift();

            for (const neighbor of graph[current]) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] === 0) {
                    queue.push(neighbor);
                    count++;
                }
            }
        }
    }

    return n == count ? res : -1;
};
//leetcode submit region end(Prohibit modification and deletion)
