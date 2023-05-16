1584
        Min Cost to Connect All Points
        2023-02-10 09:55:56

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> list = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.add(new Edge(i, j, points[i], points[j]));
            }
        }
        UnionFind uf = new UnionFind(n);
        int res = 0;
        int count = 1;
        while (count < n) {
            Edge curr = pq.poll();
            if (uf.union(curr.x, curr.y)) {
                res += curr.dist;
                count++;
            }
        }
        return res;
    }
}

class UnionFind {
    int[] group;

    public UnionFind(int n) {
        group = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
    }

    public int find(int x) {
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

class Edge {
    int x;
    int y;
    int dist;

    public Edge(int x, int y, int[] xPoint, int[] yPoint) {
        this.x = x;
        this.y = y;
        dist = Math.abs(xPoint[0] - yPoint[0]) + Math.abs(xPoint[1] - yPoint[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.add(new int[]{i, j, len});
            }
        }
        UnionFind uf = new UnionFind(n);
        int res = 0;
        int count = 1;
        while (count < n) {
            int[] curr = pq.poll();
            if (uf.union(curr[0], curr[1])) {
                res += curr[2];
                count++;
            }
        }
        return res;
    }
}

class UnionFind {
    int[] group;

    public UnionFind(int n) {
        group = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
    }

    public int find(int x) {
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
 */