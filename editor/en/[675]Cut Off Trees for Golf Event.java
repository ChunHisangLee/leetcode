//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m;
    int n;

    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));
        m = forest.size();
        n = forest.get(0).size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new int[]{i, j});
                }
            }
        }
        int res = 0;
        int start[] = {0, 0};
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            int dist = calDist(forest, start, next);
            if (dist == -1) {
                return -1;
            }
            res += dist;
            start = next;
        }
        return res;
    }

    public int calDist(List<List<Integer>> forest, int[] start, int[] end) {
        boolean[][] isVisited = new boolean[m][n];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(start);
        isVisited[start[0]][start[1]] = true;
        int dist = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] curr = dq.poll();
                int x = curr[0];
                int y = curr[1];
                if (x == end[0] && y == end[1]) {
                    return dist;
                }
                if (x + 1 < m && !isVisited[x + 1][y] && forest.get(x + 1).get(y) != 0) {
                    dq.add(new int[]{x + 1, y});
                    isVisited[x + 1][y] = true;
                }
                if (x > 0 && !isVisited[x - 1][y] && forest.get(x - 1).get(y) != 0) {
                    dq.add(new int[]{x - 1, y});
                    isVisited[x - 1][y] = true;
                }
                if (y + 1 < n && !isVisited[x][y + 1] && forest.get(x).get(y + 1) != 0) {
                    dq.add(new int[]{x, y + 1});
                    isVisited[x][y + 1] = true;
                }
                if (y > 0 && !isVisited[x][y - 1] && forest.get(x).get(y - 1) != 0) {
                    dq.add(new int[]{x, y - 1});
                    isVisited[x][y - 1] = true;
                }
            }
            dist++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
