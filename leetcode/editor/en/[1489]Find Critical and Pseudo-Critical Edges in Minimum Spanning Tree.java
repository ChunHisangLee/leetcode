/*
還不會
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int row = edges.length;
        int col = edges[0].length;
        int[][] edgeWithIndex = new int[row][col + 1];
        List<Integer> criticals = new ArrayList<>();
        List<Integer> pseduos = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            edgeWithIndex[i][0] = edges[i][0];
            edgeWithIndex[i][1] = edges[i][1];
            edgeWithIndex[i][2] = edges[i][2];
            edgeWithIndex[i][3] = i;
        }
        Arrays.sort(edgeWithIndex, (a, b) -> a[2] - b[2]);
        int minCost = buildMST(n, edgeWithIndex, null, null);
        for (int[] edge : edgeWithIndex) {
            int index = edge[3];
            int costWithout = buildMST(n, edgeWithIndex, null, edge);
            if (costWithout > minCost) {
                criticals.add(index);
            } else {
                int costWith = buildMST(n, edgeWithIndex, edge, null);
                if (costWith == minCost) {
                    pseduos.add(index);
                }
            }
        }
        return Arrays.asList(criticals, pseduos);
    }

    private int buildMST(int n, int[][] edges, int[] pick, int[] skip) {
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        if (pick != null) {
            uf.union(pick[0], pick[1]);
            cost += pick[2];
        }
        for (int[] edge : edges) {
            if (edge == skip) {
                continue;
            }
            if (uf.union(edge[0], edge[1])) {
                cost += edge[2];
            }
        }
        return uf.getCount() == 1 ? cost : Integer.MAX_VALUE;
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

    public int getCount() {
        int count = 0;
        for (int i = 0; i < group.length; i++) {
            if (group[i] == i) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][][] g = new int[n][n][2]; //{w,ind}
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            int f = e[0];
            int t = e[1];
            int w = e[2];
            g[f][t][0] = w;
            g[t][f][0] = w;
            g[f][t][1] = i;
            g[t][f][1] = i;
        }
        List<Integer>[] mst = new List[n];
        for (int i = 0; i < n; i++) {
            mst[i] = new ArrayList<>();
        }
        boolean[] mstSet = new boolean[edges.length];
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        buildMST(n, edges, mstSet, mst, g);
        List<List<Integer>> ans = new ArrayList<>(2);
        Set<Integer> pce = new HashSet<>();
        List<Integer> ce = new LinkedList<>();

        for (int i = 0; i < edges.length; i++) {
            int f = edges[i][0], t = edges[i][1];
            int w = edges[i][2];
            int ind = g[f][t][1];
            if (!mstSet[ind]) {
                Set<Integer> cur = new HashSet<>();
                boolean p = path(f, t, w, -1, mst, g, cur);
                if (p && cur.size() > 0) {
                    pce.addAll(cur);
                    pce.add(ind);
                }
                if (!p) {
                    System.out.println("Should not reach here");
                }
            }

        }

        for (int i = 0; i < edges.length; i++) {
            int f = edges[i][0], t = edges[i][1];
            int w = edges[i][2];
            int ind = g[f][t][1];
            if (mstSet[ind] && !pce.contains(ind)) {
                ce.add(ind);
            }
        }
        ans.add(ce);
        ans.add(new LinkedList<>(pce));
        return ans;
    }

    boolean path(int f, int t, int w, int p, List<Integer>[] mst, int[][][] g, Set<Integer> ind) {
        if (f == t) {
            return true;
        }
        for (int nbr : mst[f]) {
            if (p != nbr) {
                if (path(nbr, t, w, f, mst, g, ind)) {
                    if (g[f][nbr][0] == w) {
                        ind.add(g[f][nbr][1]);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void buildMST(int n, int[][] edges, boolean[] mste, List<Integer>[] mstg, int[][][] g) {
        int weight = 0;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {

            if (uf.union(edges[i][0], edges[i][1])) {
                weight += edges[i][2];
                int[] edge = edges[i];
                mstg[edge[0]].add(edge[1]);
                mstg[edge[1]].add(edge[0]);
                mste[g[edge[0]][edge[1]][1]] = true;
            }
        }
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