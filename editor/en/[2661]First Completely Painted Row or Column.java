
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int size = m * n + 1;
        int[] rowPos = new int[size];
        int[] colPos = new int[size];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int num = mat[r][c];
                rowPos[num] = r;
                colPos[num] = c;
            }
        }

        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int r = 0; r < m; r++) {
            rows[r] = n;
        }
        for (int c = 0; c < n; c++) {
            cols[c] = m;
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int r = rowPos[num];
            int c = colPos[num];
            rows[r]--;
            if (rows[r] == 0) {
                return i;
            }
            cols[c]--;
            if (cols[c] == 0) {
                return i;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
