// 1901
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int leftCol = 0;
        int rightCol = mat[0].length - 1;
        while (leftCol <= rightCol) {
            int maxRow = 0;
            int midCol = leftCol + (rightCol - leftCol) / 2;
            for (int row = 0; row < mat.length; row++) {
                maxRow = mat[row][midCol] >= mat[maxRow][midCol] ? row : maxRow;
            }
            boolean leftIsBig = midCol - 1 >= leftCol && mat[maxRow][midCol - 1] > mat[maxRow][midCol];
            boolean rightIsBig = midCol + 1 <= rightCol && mat[maxRow][midCol + 1] > mat[maxRow][midCol];
            if (!leftIsBig && !rightIsBig)
                return new int[]{maxRow, midCol};
            else if (rightIsBig)
                leftCol = midCol + 1;
            else
                rightCol = midCol - 1;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
