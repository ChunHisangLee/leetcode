// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public List<String> getLongestSubsequence(String[] words, int[] groups) {
    List<String> res = new ArrayList<>();
    int group = -1;
    int n = words.length;

    for (int i = 0; i < n; i++) {
      if (group != groups[i]) {
        res.add(words[i]);
        group = groups[i];
      }
    }

    return res;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
