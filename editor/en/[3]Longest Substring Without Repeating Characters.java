// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int lengthOfLongestSubstring(String s) {
    int length = s.length();
    int maxLength = 0;
    int start = 0;
    int[] charCount = new int[128];

    for (int end = 0; end < length; end++) {
      charCount[s.charAt(end)]++;

      while (charCount[s.charAt(end)] > 1) {
        charCount[s.charAt(start)]--;
        start++;
      }

      maxLength = Math.max(maxLength, end - start + 1);
    }

    return maxLength;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
