149
        Max Points on a Line
        2023-01-08 09:52:13

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int res = 2;
        for (int i = 0; i < n; i++) {
            int[] pointA = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] pointB = points[j];
                int count = 2;
                for (int k = j + 1; k < n; k++) {
                    int[] pointC = points[k];
                    int slope1 = (pointB[1] - pointA[1]) * (pointC[0] - pointB[0]);
                    int slope2 = (pointC[1] - pointB[1]) * (pointB[0] - pointA[0]);
                    if (slope1 == slope2) {
                        count++;
                    }
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
