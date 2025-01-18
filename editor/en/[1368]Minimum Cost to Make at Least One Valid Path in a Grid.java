
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for(int[] row: dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0, 0});

        int[][] dirs = { {0,1}, {0,-1}, {1,0}, {-1,0} };

        while(!deque.isEmpty()){
            int[] current = deque.pollFirst();
            int i = current[0];
            int j = current[1];

            int dir = grid[i][j];
            int[] d = dirs[dir - 1];
            int ni = i + d[0];
            int nj = j + d[1];

            if(ni >= 0 && ni < m && nj >= 0 && nj < n){
                if(dist[ni][nj] > dist[i][j]){
                    dist[ni][nj] = dist[i][j];
                    deque.offerFirst(new int[]{ni, nj});
                }
            }

            for(int k = 0; k < 4; k++){
                if(k == (dir - 1)) continue;
                int[] dk = dirs[k];
                int ci = i + dk[0];
                int cj = j + dk[1];
                if(ci >= 0 && ci < m && cj >= 0 && cj < n){
                    if(dist[ci][cj] > dist[i][j] + 1){
                        dist[ci][cj] = dist[i][j] + 1;
                        deque.offerLast(new int[]{ci, cj});
                    }
                }
            }
        }

        return dist[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
