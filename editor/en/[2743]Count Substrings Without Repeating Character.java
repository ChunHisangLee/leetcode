
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfSpecialSubstrings(String s) {
        int n = s.length();
        boolean[] contains = new boolean[26];
        int left = 0;
        int result = 0;

        for (int right = 0; right < n; right++) {
            char curr = s.charAt(right);

            while (contains[curr - 'a']) {
                contains[s.charAt(left) - 'a'] = false;
                left++;
            }

            contains[curr - 'a'] = true;
            result += (right - left + 1);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
