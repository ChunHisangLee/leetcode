//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] arr = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i * n + j] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }
}
//leetcode submit region right(Prohibit modification and deletion)
/*
如果難度為hard，才用這個

class Solution {
    int[][] matrix;
    int n;

    public int kthSmallest(int[][] matrix, int k) {
        this.matrix = matrix;
        n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int[] pair = {matrix[0][0], matrix[n - 1][n - 1]};
            int count = cmp(mid, pair);
            if (count == k) {
                return pair[0];
            }
            if (count < k) {
                left = pair[1];
            } else {
                right = pair[0];
            }
        }
        return left;
    }

    public int cmp(int mid, int[] pair) {
        int count = 0;
        int x = n - 1;
        int y = 0;
        while (y < n && x >= 0) {
            if (matrix[x][y] > mid) {
                pair[1] = Math.min(pair[1], matrix[x][y]);
                x--;
            } else {
                pair[0] = Math.max(pair[0], matrix[x][y]);
                count += x + 1;
                y++;
            }
        }
        return count;
    }
}
 */