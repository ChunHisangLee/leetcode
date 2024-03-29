1584
        Min Cost to Connect All Points
        2023-02-10 09:55:56

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = getDist(points[i], points[j]);
                pq.add(new int[]{i, j, len});
            }
        }
        UnionFind uf = new UnionFind(n);
        int count = 1;
        int res = 0;
        while (count < n) {
            int[] curr = pq.poll();
            if (uf.union(curr[0], curr[1])) {
                res += curr[2];
                count++;
            }
        }
        return res;
    }

    public int getDist(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }
}

class UnionFind {
    private int[] group;

    public UnionFind(int n) {
        group = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
    }

    private int find(int x) {
        return group[x] == x ? x : (group[x] = find(group[x]));
    }

    public boolean union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x == y) {
            return false;
        }
        group[x] = y;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int res = 0;
        int count = 0;
        boolean[] isVisited = new boolean[n];
        int[] arr = new int[n];
        arr[0] = 0;
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        while (count < n) {
            int num = Integer.MAX_VALUE;
            int vertex = -1;
            for (int i = 0; i < n; i++) {
                if (!isVisited[i] && num > arr[i]) {
                    num = arr[i];
                    vertex = i;
                }
            }
            res += num;
            count++;
            isVisited[vertex] = true;
            for (int i = 0; i < n; i++) {
                int weight = Math.abs(points[vertex][0] - points[i][0]) + Math.abs(points[vertex][1] - points[i][1]);
                if (!isVisited[i] && arr[i] > weight) {
                    arr[i] = weight;
                }
            }
        }
        return res;
    }
}
 */