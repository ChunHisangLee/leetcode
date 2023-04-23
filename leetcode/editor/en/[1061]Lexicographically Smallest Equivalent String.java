1061
        Lexicographically Smallest Equivalent String
        2023-01-14 09:03:13

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind();
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

    class UnionFind {
        int[] parent;
        int total;

        public UnionFind() {
            total = 26;
            parent = new int[total];
            for (int i = 0; i < total; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa <= pb) {
                parent[pb] = pa;
            } else {
                parent[pa] = pb;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
