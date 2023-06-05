1061
        Lexicographically Smallest Equivalent String
        2023-01-14 09:03:13

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] cb = baseStr.toCharArray();
        UnionFind uf = new UnionFind(26);
        for (int i = 0; i < c1.length; i++) {
            uf.union(c1[i] - 'a', c2[i] - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cb.length; i++) {
            int p = uf.find(cb[i] - 'a');
            sb.append(uf.getChar(p));
        }
        return sb.toString();
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
        if (x > y) {
            group[x] = y;
        } else {
            group[y] = x;
        }
    }

    public char getChar(int c) {
        return (char) (c + 'a');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
