
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isReflected(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int sum = points[0][0] + points[points.length - 1][0];
        for (int[] point : points) {
            int target = sum - point[0];
            if (!isCheck(points, target, point[1])) {
                return false;
            }
        }
        return true;
    }

    public boolean isCheck(int[][] points, int x, int y) {
        int left = 0;
        int right = points.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (points[mid][0] == x && points[mid][1] == y) {
                return true;
            }
            if (points[mid][0] == x) {
                if (points[mid][1] > y) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (points[mid][0] > x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
