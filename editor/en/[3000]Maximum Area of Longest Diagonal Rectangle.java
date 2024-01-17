//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal = 0;
        int maxArea = 0;

        for (int[] diemension : dimensions) {
            int length = diemension[0];
            int width = diemension[1];
            double diagonal = Math.sqrt(length * length + width * width);
            int area = length * width;

            if (diagonal > maxDiagonal || diagonal == maxDiagonal && area > maxArea) {
                maxDiagonal = diagonal;
                maxArea = area;
            }
        }

        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
