
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int col = findMin(matrix, i);
            int maxCol = matrix[i][col];

            if (maxInCol(matrix, maxCol, col)) {
                result.add(maxCol);
            }
        }

        return result;
    }

    private int findMin(int[][] matrix, int row) {
        int val = matrix[row][0];
        int col = 0;

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[row][i] < val) {
                val = matrix[row][i];
                col = i;
            }
        }

        return col;
    }

    private boolean maxInCol(int[][] matrix, int val, int col) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] > val) {
                return false;
            }
        }

        return true;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
