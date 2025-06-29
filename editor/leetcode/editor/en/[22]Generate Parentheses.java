// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(result, new StringBuilder(), 0, 0, n);
    return result;
  }

  private void backtrack(
      List<String> list, StringBuilder curr, int openCount, int closeCount, int maxPairs) {
    if (curr.length() == maxPairs * 2) {
      list.add(curr.toString());
      return;
    }

    if (openCount < maxPairs) {
      curr.append("(");
      backtrack(list, curr, openCount + 1, closeCount, maxPairs);
      curr.deleteCharAt(curr.length() - 1);
    }

    if (closeCount < openCount) {
      curr.append(")");
      backtrack(list, curr, openCount, closeCount + 1, maxPairs);
      curr.deleteCharAt(curr.length() - 1);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
