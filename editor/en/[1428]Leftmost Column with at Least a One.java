
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int row = dimensions.get(0);
        int col = dimensions.get(1);
        int currRow = 0;
        int currCol = col - 1;
        int result = -1;

        while (currRow < row && currCol >= 0) {
            if (binaryMatrix.get(currRow, currCol) == 1) {
                result = currCol;
                currCol--;
            } else {
                currRow++;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
