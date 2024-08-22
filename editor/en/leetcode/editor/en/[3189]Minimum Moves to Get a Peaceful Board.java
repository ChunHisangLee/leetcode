//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMoves(int[][] rooks) {
        int n = rooks.length;
        int[] rows = new int[n];
        int[] cols = new int[n];

        for (int i = 0; i < n; i++) {
            rows[rooks[i][0]]++;
            cols[rooks[i][1]]++;
        }

        int minMoves = 0;
        int rowMinMoves = 0;
        int colMinMoves = 0;

        for (int i = 0; i < n; i++) {
            rowMinMoves += rows[i] - 1;
            colMinMoves += cols[i] - 1;
            minMoves += Math.abs(rowMinMoves) + Math.abs(colMinMoves);
        }

        return minMoves;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
