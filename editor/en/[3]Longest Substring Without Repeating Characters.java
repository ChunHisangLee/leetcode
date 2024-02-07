// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int lengthOfLongestSubstring(String s) {
    int[] arr = new int[128];
    char[] c = s.toCharArray();
    int n = c.length;
    int left = 0;
    int right = 0;
    int max = 0;

    while (right < n) {
      if (arr[c[right]] == 0) {
        arr[c[right]] = 1;
        right++;
      } else {
        arr[c[left]] = 0;
        left++;
      }

      max = Math.max(max, right - left);
    }

    return max;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
