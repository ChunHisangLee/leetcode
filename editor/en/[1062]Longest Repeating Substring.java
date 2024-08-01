
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestRepeatingSubstring(String s) {
        int left = 0;
        int right = s.length();
        int mid;
        int result = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (hasRepeatingSubstring(s, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean hasRepeatingSubstring(String s, int length) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i <= s.length() - length; i++) {
            String substr = s.substring(i, i + length);

            if (!seen.add(substr)) {
                return true;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
