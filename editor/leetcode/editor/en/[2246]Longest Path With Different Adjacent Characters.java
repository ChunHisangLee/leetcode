// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  int result = 0;

  public int longestPath(int[] parent, String s) {
    int n = parent.length;
    List<Integer>[] children = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      children[i] = new ArrayList<>();
    }

    for (int i = 1; i < n; i++) {
      children[parent[i]].add(i);
    }

    checkPath(0, children, s);
    return result;
  }

  private int checkPath(int node, List<Integer>[] children, String s) {
    int first = 0;
    int second = 0;

    for (int child : children[node]) {
      int childPath = checkPath(child, children, s);

      if (s.charAt(child) == s.charAt(node)) {
        continue;
      }

      if (childPath > first) {
        second = first;
        first = childPath;
      } else if (childPath > second) {
        second = childPath;
      }
    }

    result = Math.max(result, first + second + 1);
    return first + 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
