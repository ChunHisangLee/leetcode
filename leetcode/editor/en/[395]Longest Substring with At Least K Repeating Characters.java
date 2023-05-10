395
        Longest Substring with At Least K Repeating Characters
        2023-01-31 10:50:52

/*
還不會
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubstring(String s, int k) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        boolean isValid = true;
        int left = 0;
        int res = 0;
        char[] c = s.toCharArray();
        int n = c.length;
        for (int right = 0; right < n; right++) {
            if (arr[c[right] - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(left, right), k));
                isValid = false;
                left = right + 1;
            }
        }
        return isValid ? n : Math.max(res, longestSubstring(s.substring(left), k));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
