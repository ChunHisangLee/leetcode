2352
        Equal Row and Column Pairs
        2022-11-28 16:22:06

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = grid[j][i];
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Arrays.equals(arr[i], grid[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
HashMap: - 50ms
class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> mapRow = new HashMap<>();
        for (int[] row : grid) {
            String key = convertToKey(row);
            mapRow.put(key, mapRow.getOrDefault(key, 0) + 1);
        }
        Map<String, Integer> mapCol = new HashMap<>();
        for (int col = 0; col < grid[0].length; col++) {
            int[] currCol = new int[grid.length];
            for (int row = 0; row < grid.length; row++) {
                currCol[row] = grid[row][col];
            }
            String key = convertToKey(currCol);
            mapCol.put(key, mapCol.getOrDefault(key, 0) + 1);
        }
        int ans = 0;
        for (String key : mapRow.keySet()) {
            ans += mapRow.get(key) * mapCol.getOrDefault(key, 0);
        }
        return ans;
    }

    private String convertToKey(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            sb.append(",");
        }
        return sb.toString();
    }
}
 */