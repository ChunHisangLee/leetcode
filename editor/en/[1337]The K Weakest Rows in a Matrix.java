import java.util.Queue;

// 1337
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int num = mat.length;
        int[] weakest = new int[num];
        int[] copy = new int[num];
        int[] result = new int[k];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    weakest[i]++;
            }
        }
        for (int i = 0; i < num; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < num; j++) {
                if (weakest[j] < min) {
                    min = weakest[j];
                    minIndex = j;
                }
            }
            copy[i] = minIndex;
            weakest[minIndex] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < k; i++) {
            result[i] = copy[i];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
