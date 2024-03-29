//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int result = 1;
        int reach = points[0][1];

        for (int[] point : points) {
            if (point[0] > reach) {
                result++;
                reach = point[1];
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
