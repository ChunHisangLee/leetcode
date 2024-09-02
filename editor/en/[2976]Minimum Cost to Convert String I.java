//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        final int ALPHABET_SIZE = 26;
        int m = original.length;
        int n = target.length();
        int[][] minCost = new int[ALPHABET_SIZE][ALPHABET_SIZE];

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
            minCost[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            minCost[from][to] = Math.min(minCost[from][to], cost[i]);
        }

        for (int k = 0; k < ALPHABET_SIZE; k++) {
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                if (minCost[i][k] < Integer.MAX_VALUE) {
                    for (int j = 0; j < ALPHABET_SIZE; j++) {
                        if (minCost[k][j] < Integer.MAX_VALUE) {
                            minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                        }
                    }
                }
            }
        }

        long totalCost = 0;

        for (int i = 0; i < n; i++) {
            if (source.charAt(i) == target.charAt(i)) {
                continue;
            }

            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';

            if (minCost[from][to] == Integer.MAX_VALUE) {
                return -1;
            }

            totalCost += minCost[from][to];
        }

        return totalCost;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
