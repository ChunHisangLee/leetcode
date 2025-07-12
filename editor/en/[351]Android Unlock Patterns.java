
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] jump = new int[10][10];
        jump[1][3] = jump[3][1] = 2;
        jump[1][7] = jump[7][1] = 4;
        jump[3][9] = jump[9][3] = 6;
        jump[7][9] = jump[9][7] = 8;
        jump[1][9] = jump[9][1] = jump[2][8] = jump[8][2] = jump[3][7] = jump[7][3] = jump[4][6] = jump[6][4] = 5;

        boolean[] visited = new boolean[10];
        int result = 0;
        result += 4 * dfs(1, 1, 0, m, n, visited, jump);
        result += 4 * dfs(2, 1, 0, m, n, visited, jump);
        result += dfs(5, 1, 0, m, n, visited, jump);
        return result;
    }

    private int dfs(int num, int len, int count, int m, int n, boolean[] visited, int[][] jump) {
        if (len >= m) {
            count++;
        }

        if (len == n) {
            return count;
        }

        visited[num] = true;

        for (int next = 1; next <= 9; next++) {
            int j = jump[num][next];

            if (!visited[next] && (j == 0 || visited[j])) {
                count = dfs(next, len + 1, count, m, n, visited, jump);
            }
        }

        visited[num] = false;
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
