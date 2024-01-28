
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                map.clear();
                map.put(0, 1);
                int sum = 0;

                for (int k = 0; k < m; k++) {
                    sum += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    result += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
