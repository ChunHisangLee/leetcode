// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int left = 0;
    int maxCount = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int right = 0; right < n; right++) {
      char c = s.charAt(right);

      if (map.containsKey(c)) {
        left = Math.max(left, map.get(c) + 1);
      }

      map.put(c, right);
      maxCount = Math.max(maxCount, right - left + 1);
    }

    return maxCount;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
