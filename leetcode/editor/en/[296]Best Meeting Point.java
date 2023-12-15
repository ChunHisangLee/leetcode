
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> pointX = new ArrayList<>();
        List<Integer> pointY = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    pointX.add(i);
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    pointY.add(j);
                }
            }
        }

        return getMin(pointX) + getMin(pointY);
    }

    private int getMin(List<Integer> list) {
        int sum = 0;
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            sum += list.get(j--) - list.get(i++);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
