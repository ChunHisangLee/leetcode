
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int totalDist = 0;
        int dist = Integer.MIN_VALUE;

        for (int[] nut : nuts) {
            int nutToTree = getDist(nut, tree);
            totalDist += nutToTree * 2;
            dist = Math.max(dist, nutToTree - getDist(nut, squirrel));
        }

        return totalDist - dist;
    }

    private int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
