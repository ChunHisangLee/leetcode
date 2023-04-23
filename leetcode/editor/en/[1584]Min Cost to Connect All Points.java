1584
        Min Cost to Connect All Points
        2023-02-10 09:55:56

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int res = 0;
        int count = 0;
        boolean[] isVisited = new boolean[n];
        int[] arr = new int[n];
        arr[0] = 0;
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        while (count < n) {
            int num = Integer.MAX_VALUE;
            int node = -1;
            for (int i = 0; i < n; i++) {
                if (!isVisited[i] && num > arr[i]) {
                    num = arr[i];
                    node = i;
                }
            }
            res += num;
            count++;
            isVisited[node] = true;
            for (int i = 0; i < n; i++) {
                int weight = Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);
                if (!isVisited[i] && arr[i] > weight) {
                    arr[i] = weight;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
