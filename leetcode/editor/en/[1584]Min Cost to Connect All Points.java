1584
        Min Cost to Connect All Points
        2023-02-10 09:55:56

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));
        boolean[] inMST = new boolean[n];
        pq.add(new Pair(0, 0));
        int mstCost = 0;
        int edgesUsed = 0;
        while (edgesUsed < n) {
            Pair<Integer, Integer> topElement = pq.poll();
            int weight = topElement.getKey();
            int currNode = topElement.getValue();
            if (inMST[currNode]) {
                continue;
            }
            inMST[currNode] = true;
            mstCost += weight;
            edgesUsed++;
            for (int nextNode = 0; nextNode < n; ++nextNode) {
                if (!inMST[nextNode]) {
                    int nextWeight = Math.abs(points[currNode][0] - points[nextNode][0]) +
                            Math.abs(points[currNode][1] - points[nextNode][1]);

                    pq.add(new Pair(nextWeight, nextNode));
                }
            }
        }
        return mstCost;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                list.add(new int[]{i, j, len});
            }
        }
        Collections.sort(list, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(n);
        int res = 0;
        int count = 0;
        for (int i = 0; i < list.size() && count < n - 1; i++) {
            int[] curr = list.get(i);
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