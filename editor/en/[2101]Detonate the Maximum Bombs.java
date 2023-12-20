
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> list = new ArrayList<>();
        int n = bombs.length;
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            int x1 = bombs[i][0];
            int y1 = bombs[i][1];
            int r1 = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int x2 = bombs[j][0];
                int y2 = bombs[j][1];
                if ((long) (x2 - x1) * (x2 - x1) + (long) (y2 - y1) * (y2 - y1) <= (long) r1 * r1) {
                    list.get(i).add(j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, list, new boolean[n]));
            if (res == n) {
                return res;
            }
        }
        return res;
    }

    public int dfs(int i, List<List<Integer>> list, boolean[] isVisited) {
        if (isVisited[i]) {
            return 0;
        }
        isVisited[i] = true;
        int count = 1;
        for (int num : list.get(i)) {
            count += dfs(num, list, isVisited);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
DFS - 13ms
class Solution {
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> list = new ArrayList<>();
        int n = bombs.length;
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            int xi = bombs[i][0];
            int yi = bombs[i][1];
            int ri = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int xj = bombs[j][0];
                int yj = bombs[j][1];
                if ((long) ri * ri >= (long) (xi - xj) * (xi - xj) + (long) (yi - yj) * (yi - yj)) {
                    list.get(i).add(j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, list, new boolean[n]));
            if (res == n) {
                return res;
            }
        }
        return res;
    }

    public int dfs(int i, List<List<Integer>> list, boolean[] isVisited) {
        if (isVisited[i]) {
            return 0;
        }
        isVisited[i] = true;
        int count = 1;
        for (int key : list.get(i)) {
            count += dfs(key, list, isVisited);
        }
        return count;
    }
}


BFS - 19ms
class Solution {
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> list = new ArrayList<>();
        int n = bombs.length;
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            int xi = bombs[i][0];
            int yi = bombs[i][1];
            int ri = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int xj = bombs[j][0];
                int yj = bombs[j][1];
                if ((long) ri * ri >= (long) (xi - xj) * (xi - xj) + (long) (yi - yj) * (yi - yj)) {
                    list.get(i).add(j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, bfs(i, list));
            if (res == n) {
                return res;
            }
        }
        return res;
    }

    public int bfs(int i, List<List<Integer>> list) {
        Deque<Integer> dq = new ArrayDeque<>();
        Set<Integer> visit = new HashSet<>();
        dq.add(i);
        visit.add(i);
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            for (int key : list.get(curr)) {
                if (!visit.contains(key)) {
                    dq.add(key);
                    visit.add(key);
                }
            }
        }
        return visit.size();
    }
}
 */