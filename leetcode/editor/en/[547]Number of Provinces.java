547
        Numbers of Provinces
        2022-11-26 11:34:33

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[] isVisited;
    int n;

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        isVisited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                count++;
                dfs(isConnected, i);
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, int x) {
        isVisited[x] = true;
        for (int i = 0; i < n; i++) {
            if (isConnected[x][i] == 1 && !isVisited[i]) {
                dfs(isConnected, i);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    int[] group;
    int count;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        group = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    union(i, j);
                }
            }
        }
        return count;
    }

    public int find(int x) {
        return group[x] == x ? x : (group[x] = find(group[x]));
    }

    public void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            group[x] = y;
            count--;
        }
    }
}
 */