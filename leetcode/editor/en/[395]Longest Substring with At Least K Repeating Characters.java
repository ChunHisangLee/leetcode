395
        Longest Substring with At Least K Repeating Characters
        2023-01-31 10:50:52

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubstring(String s, int k) {
        int[] arr = new int[26];
        int res = 0;
        int left = 0;
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        boolean isValid = true;
        char[] c = s.toCharArray();
        for (int right = 0; right < c.length; right++) {
            if (arr[c[right] - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(left, right), k));
                isValid = false;
                left = right + 1;
            }
        }
        return isValid ? s.length() : Math.max(res, longestSubstring(s.substring(left), k));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
