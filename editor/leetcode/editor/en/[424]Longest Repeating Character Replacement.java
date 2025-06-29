// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int characterReplacement(String s, int k) {
    int n = s.length();
    int maxCount = 0;
    int left = 0;
    int result = 0;
    int[] freq = new int[26];

    for (int right = 0; right < n; right++) {
      int rightIndex = s.charAt(right) - 'A';
      freq[rightIndex]++;
      maxCount = Math.max(maxCount, freq[rightIndex]);

      if ((right - left + 1) - maxCount > k) {
        int leftIndex = s.charAt(left) - 'A';
        freq[leftIndex]--;
        left++;
      }

      result = Math.max(result, right - left + 1);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
