
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int longestPalindrome(String[] words) {
    int[][] count = new int[26][26];
    int result = 0;

    for (String word : words) {
      int first = word.charAt(0) - 'a';
      int second = word.charAt(1) - 'a';

      if (count[second][first] > 0) {
        result += 4;
        count[second][first]--;
      } else {
        count[first][second]++;
      }
    }

    for (int i = 0; i < 26; i++) {
      if (count[i][i] > 0) {
        result += 2;
        break;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
