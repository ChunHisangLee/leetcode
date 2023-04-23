1439
        Find the Kth Smallest Sum of a Matrix With Sorted Rows
        2022-12-19 11:42:42

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int count;
    private int m;
    private int n;

    public int kthSmallest(int[][] mat, int k) {
        this.m = mat.length;
        this.n = mat[0].length;
        int left = 0;
        int right = 0;
        for (int i = 0; i < this.m; i++) {
            left += mat[i][0];
            right += mat[i][this.n - 1];
        }
        int base = left;
        while (left < right) {
            int mid = left + (right - left) / 2;
            this.count = 0;
            countLessMiddle(mat, k, mid, base, 0);
            if (this.count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private void countLessMiddle(int[][] mat, int k, int mid, int base, int row) {
        if (row == this.m) {
            this.count++;
            return;
        }
        for (int i = 0; i < this.n; i++) {
            int currSum = base + mat[row][i] - mat[row][0];
            if (currSum > mid || this.count >= k) {
                break;
            }
            countLessMiddle(mat, k, mid, currSum, row + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
