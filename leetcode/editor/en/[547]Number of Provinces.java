547
        Numbers of Provinces
        2022-11-26 11:34:33

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] arr = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                dq.add(i);
                arr[i] = 1;
                count++;
                while (!dq.isEmpty()) {
                    int curr = dq.poll();
                    for (int j = 0; j < n; j++) {
                        if (isConnected[curr][j] == 1 && arr[j] == 0) {
                            dq.add(j);
                            arr[j] = 1;
                        }
                    }
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
DFS:
class Solution {
    int[] arr;
    int n;

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        arr = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count++;
                dfs(isConnected, i);
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, int x) {
        arr[x] = 1;
        for (int i = 0; i < n; i++) {
            if (isConnected[x][i] == 1 && arr[i] == 0) {
                dfs(isConnected, i);
            }
        }
    }
}


BFS:
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] arr = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                dq.add(i);
                arr[i] = 1;
                count++;
                while (!dq.isEmpty()) {
                    int curr = dq.poll();
                    for (int j = 0; j < n; j++) {
                        if (isConnected[curr][j] == 1 && arr[j] == 0) {
                            dq.add(j);
                            arr[j] = 1;
                        }
                    }
                }
            }
        }
        return count;
    }
}


Union:
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
}

class UnionFind {
    int[] group;
    int count;

    public UnionFind(int n) {
        group = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
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

    public int getCount() {
        return count;
    }
}
 */