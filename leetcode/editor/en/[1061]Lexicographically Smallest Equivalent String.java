1061
        Lexicographically Smallest Equivalent String
        2023-01-14 09:03:13

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind(26);
        for (int i = 0; i < s1.length(); i++) {
            uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            int p = uf.find(baseStr.charAt(i) - 'a');
            sb.append((char) (p + 'a'));
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
}
//leetcode submit region end(Prohibit modification and deletion)
