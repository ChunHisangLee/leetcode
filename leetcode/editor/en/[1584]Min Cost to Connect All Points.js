//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[][]} points
 * @return {number}
 */
var minCostConnectPoints = function (points) {
    const n = points.length;
    let res = 0;
    const edges = [];
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            const dist = Math.abs(points[i][0] - points[j][0]) +
                Math.abs(points[i][1] - points[j][1]);
            edges.push([i, j, dist]);
        }
    }

    edges.sort((a, b) => a[2] - b[2]);

    const group = Array.from({length: n}, (_, i) => i);

    function find(x) {
        return group[x] == x ? x : (group[x] = find(group[x]));
    }

    let count = 0;
    for (const [i, j, dist] of edges) {
        const x = find(i);
        const y = find(j);
        if (x !== y) {
            res += dist;
            group[x] = y;
            count++;
            if (count === n - 1) {
                break;
            }
        }
    }
    return res;
};
//leetcode submit region end(Prohibit modification and deletion)
/*
- 1084ms
var minCostConnectPoints = function (points) {
    const n = points.length;
    let res = 0;
    const edges = [];
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            const dist = Math.abs(points[i][0] - points[j][0]) +
                Math.abs(points[i][1] - points[j][1]);
            edges.push([i, j, dist]);
        }
    }

    edges.sort((a, b) => a[2] - b[2]);

    const group = Array.from({length: n}, (_, i) => i);

    function find(x) {
        return group[x] == x ? x : (group[x] = find(group[x]));
    }

    let count = 0;
    for (const [i, j, dist] of edges) {
        const x = find(i);
        const y = find(j);
        if (x !== y) {
            res += dist;
            group[x] = y;
            count++;
            if (count === n - 1) {
                break;
            }
        }
    }
    return res;
};

- 82ms
var minCostConnectPoints = function (points) {
    const n = points.length;
    let res = 0;
    let count = 0;

    let isVisited = new Array(n).fill(false);
    let arr = new Array(n).fill(Infinity);
    arr[0] = 0;

    while (count < n) {
        let num = Infinity;
        let vertex = -1;

        for (let i = 0; i < n; i++) {
            if (!isVisited[i] && num > arr[i]) {
                num = arr[i];
                vertex = i;
            }
        }

        res += num;
        count++;
        isVisited[vertex] = true;

        for (let i = 0; i < n; i++) {
            let weight = Math.abs(points[vertex][0] - points[i][0]) +
                Math.abs(points[vertex][1] - points[i][1]);
            if (!isVisited[i] && arr[i] > weight) {
                arr[i] = weight;
            }
        }
    }
    
    return res;
};
 */