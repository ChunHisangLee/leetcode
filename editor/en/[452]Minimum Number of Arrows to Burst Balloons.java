452
        Minimum Number of Arrows to Burst Balloons
        2023-01-05 09:38:34

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 1;
        int reach = points[0][1];
        for (int[] point : points) {
            if (point[0] > reach) {
                res++;
                reach = point[1];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
