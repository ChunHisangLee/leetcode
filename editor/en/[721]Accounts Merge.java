
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, Integer> emailToId = new HashMap<>();
    Map<String, String> emailToName = new HashMap<>();
    int idCounter = 0;

    for (List<String> account : accounts) {
      String name = account.get(0);
      for (int i = 1; i < account.size(); i++) {
        String email = account.get(i);
        if (!emailToId.containsKey(email)) {
          emailToId.put(email, idCounter);
          idCounter++;
          emailToName.put(email, name);
        }
      }
    }

    UnionFind uf = new UnionFind(idCounter);
    for (List<String> account : accounts) {
      int firstId = emailToId.get(account.get(1));

      for (int i = 2; i < account.size(); i++) {
        uf.union(firstId, emailToId.get(account.get(i)));
      }
    }

    Map<Integer, List<String>> groups = new HashMap<>();
    for (String email : emailToId.keySet()) {
      int root = uf.find(emailToId.get(email));
      if (!groups.containsKey(root)) {
        groups.put(root, new ArrayList<>());
      }
      groups.get(root).add(email);
    }

    List<List<String>> merged = new ArrayList<>();
    for (List<String> emailList : groups.values()) {
      Collections.sort(emailList);
      String name = emailToName.get(emailList.get(0));
      List<String> account = new ArrayList<>();
      account.add(name);
      account.addAll(emailList);
      merged.add(account);
    }

    return merged;
  }

  private static class UnionFind {
    private final int[] parent;
    private final int[] rank;

    UnionFind(int n) {
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        rank[i] = 1;
      }
    }

    int find(int x) {
      if (parent[x] != x) {
        parent[x] = find(parent[x]);
      }

      return parent[x];
    }

    void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);

      if (rootX == rootY) {
        return;
      }

      if (rank[rootX] < rank[rootY]) {
        parent[rootX] = rootY;
      } else if (rank[rootX] > rank[rootY]) {
        parent[rootY] = rootX;
      } else {
        parent[rootY] = rootX;
        rank[rootX]++;
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
