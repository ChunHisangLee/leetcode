// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> result = new ArrayList<>();
    int n = words.length;

    for (int i = 0; i < n; i++) {
      if (words[i].indexOf(x) >= 0) {
        result.add(i);
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
