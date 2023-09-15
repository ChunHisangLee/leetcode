//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[][]} points
 * @return {number}
 */
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
//leetcode submit region end(Prohibit modification and deletion)
