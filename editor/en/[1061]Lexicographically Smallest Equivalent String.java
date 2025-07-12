// leetcode submit region begin(Prohibit modification and deletion)
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
  private final int[] parent;

  public UnionFind(int n) {
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  public int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX == rootY) {
      return;
    }
    if (rootX < rootY) {
      parent[rootY] = rootX;
    } else {
      parent[rootX] = rootY;
    }
  }

  public char getChar(int x) {
    return (char) (x + 'a');
  }
}
// leetcode submit region end(Prohibit modification and deletion)
