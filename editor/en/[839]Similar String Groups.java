
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);
        int count = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j]) && uf.find(i) != uf.find(j)) {
                    uf.union(i, j);
                    count--;
                }
            }
        }
        return count;
    }

    public boolean isSimilar(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 2) {
                    return false;
                }
            }
        }
        return diff != 1;
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

    public void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            group[x] = y;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
DFS: - 18ms
class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    map.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    map.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                }
            }
        }
        boolean[] isVisited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(i, map, isVisited);
                count++;
            }
        }
        return count;
    }

    public boolean isSimilar(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 2) {
                    return false;
                }
            }
        }
        return diff != 1;
    }

    public void dfs(int node, Map<Integer, List<Integer>> map, boolean[] isVisited) {
        isVisited[node] = true;
        if (!map.containsKey(node)) {
            return;
        }
        for (int num : map.get(node)) {
            if (!isVisited[num]) {
                isVisited[num] = true;
                dfs(num, map, isVisited);
            }
        }
    }
}
DFS: - 10ms
class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        boolean[] isVisited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(strs[i], isVisited, strs);
                count++;
            }
        }
        return count;
    }

    public boolean isSimilar(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 2) {
                    return false;
                }
            }
        }
        return diff != 1;
    }

    public void dfs(String str, boolean[] isVisited, String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            if (!isVisited[i] && isSimilar(str, strs[i])) {
                isVisited[i] = true;
                dfs(strs[i], isVisited, strs);
            }
        }
    }
}


BFS: -18ms

Union Find:
class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);
        int count = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j]) && uf.find(i) != uf.find(j)) {
                    count--;
                    uf.union(i, j);
                }
            }
        }
        return count;
    }

    public boolean isSimilar(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 2) {
                    return false;
                }
            }
        }
        return diff != 1;
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

    public void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            group[x] = y;
        }
    }
}
 */