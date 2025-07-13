
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sbInverse = new StringBuilder();

            for (int num : row) {
                sb.append(num);
                sb.append(',');
                sbInverse.append(num == 0 ? '1' : '0');
                sbInverse.append(',');
            }

            String pattern = sb.toString();
            String inversePattern = sbInverse.toString();
            String key = pattern.compareTo(inversePattern) < 0 ? pattern : inversePattern;
            patternCount.put(key, patternCount.getOrDefault(key, 0) + 1);
        }

        int maxCount = 0;

        for (int count : patternCount.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
