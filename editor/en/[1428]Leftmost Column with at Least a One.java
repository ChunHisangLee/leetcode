1428
        Leftmost Column with at Least a One
        2022-12-29 13:16:09
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 * public int get(int row, int col) {}
 * public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        int currRow = 0;
        int currCol = col - 1;
        while (currRow < row && currCol >= 0) {
            if (binaryMatrix.get(currRow, currCol) == 0) {
                currRow++;
            } else {
                currCol--;
            }
        }
        return currCol == col - 1 ? -1 : currCol + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
