1202
        Smallest String With Swaps
        2023-02-03 16:53:41

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            map.putIfAbsent(root, new ArrayList<>());
            map.get(root).add(i);
        }
        char[] result = new char[n];
        for (List<Integer> indices : map.values()) {
            List<Character> ch = new ArrayList<>();
            for (int index : indices) {
                ch.add(s.charAt(index));
            }
            Collections.sort(ch);
            for (int index = 0; index < indices.size(); index++) {
                result[indices.get(index)] = ch.get(index);
            }
        }
        return new String(result);
    }
}

class UnionFind {
    private int[] root;

    public UnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        return root[x] == x ? x : (root[x] = find(root[x]));
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootX] = rootY;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
