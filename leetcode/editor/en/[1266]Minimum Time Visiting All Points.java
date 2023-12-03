
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;

        for (int i = 1; i < points.length; i++) {
            totalTime += getTime(points[i - 1], points[i]);
        }

        //  System.gc();     用了 2 ms，少了1.5MB
        return totalTime;
    }

    private int getTime(int[] curr, int[] next) {
        int deltaX = Math.abs(next[0] - curr[0]);
        int deltaY = Math.abs(next[1] - curr[1]);
        return Math.max(deltaX, deltaY);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
