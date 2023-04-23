// 74
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = matrix[mid / n][mid % n];
            if (val == target)
                return true;
            else if (val > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
