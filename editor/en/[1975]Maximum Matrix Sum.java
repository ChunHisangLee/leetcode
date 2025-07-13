
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int negativeCount = 0;
        int smallestAbs = Integer.MAX_VALUE;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] < 0) {
                    negativeCount++;
                }

                totalSum += Math.abs(matrix[i][j]);
                smallestAbs = Math.min(smallestAbs, Math.abs(matrix[i][j]));
            }
        }

        if(negativeCount % 2 != 0) {
            totalSum -= 2 * smallestAbs;
        }

        return totalSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
