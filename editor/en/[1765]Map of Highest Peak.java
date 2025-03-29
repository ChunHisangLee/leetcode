
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];

        for(int[] row : height){
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    height[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int currentHeight = height[cell[0]][cell[1]];

            for(int[] dir : directions){
                int ni = cell[0] + dir[0];
                int nj = cell[1] + dir[1];

                if(ni >=0 && ni < m && nj >=0 && nj < n && height[ni][nj] == -1){
                    height[ni][nj] = currentHeight + 1;
                    queue.offer(new int[]{ni, nj});
                }
            }
        }

        return height;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
