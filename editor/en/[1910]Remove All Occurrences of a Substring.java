// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public String removeOccurrences(String s, String part) {
    StringBuilder res = new StringBuilder();
    int partLen = part.length();

    for (char c : s.toCharArray()) {
      res.append(c);

      if (res.length() >= partLen && res.substring(res.length() - partLen).equals(part)) {
        res.delete(res.length() - partLen, res.length());
      }
    }

    return res.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
