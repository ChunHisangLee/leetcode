
//leetcode submit region begin(Prohibit modification and deletion)
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
            res = Math.max(res, dfs(i, list, new HashSet<>()));
            if (res == n) {
                return res;
            }
        }
        return res;
    }

    public int dfs(int i, List<List<Integer>> list, Set<Integer> visit) {
        visit.add(i);
        int count = 1;
        for (int key : list.get(i)) {
            if (!visit.contains(key)) {
                count += dfs(key, list, visit);
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
DFS - 19ms
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
            res = Math.max(res, dfs(i, list, new HashSet<>()));
            if (res == n) {
                return res;
            }
        }
        return res;
    }

    public int dfs(int i, List<List<Integer>> list, Set<Integer> visit) {
        visit.add(i);
        int count = 1;
        for (int key : list.get(i)) {
            if (!visit.contains(key)) {
                count += dfs(key, list, visit);
            }
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