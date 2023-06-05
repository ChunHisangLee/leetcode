990
        Satisfiability of Equality Equations
        2023-03-03 11:44:47

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String equ : equations) {
            char[] c = equ.toCharArray();
            if (c[1] == '=') {
                int x = c[0] - 'a';
                int y = c[3] - 'a';
                uf.union(x, y);
            }
        }
        for (String equ : equations) {
            char[] c = equ.toCharArray();
            if (c[1] == '!') {
                int x = c[0] - 'a';
                int y = c[3] - 'a';
                if (uf.find(x) == uf.find(y)) {
                    return false;
                }
            }
        }
        return true;
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
