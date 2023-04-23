
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int diffX = x - points[i][0];
                int diffY = y - points[i][1];
                if (Math.abs(diffX) + Math.abs(diffY) < min) {
                    min = Math.abs(diffX) + Math.abs(diffY);
                    res = i;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
