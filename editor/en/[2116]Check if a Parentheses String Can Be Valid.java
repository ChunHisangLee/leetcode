//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();

        if (n % 2 != 0) {
            return false;
        }

        int lower = 0;
        int upper = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            char lock = locked.charAt(i);

            if (lock == '1') {
                if (c == '(') {
                    lower++;
                    upper++;
                } else {
                    lower--;
                    upper--;
                }
            } else {
                lower--;
                upper++;
            }

            if (lower < 0) {
                lower = 0;
            }

            if (upper < 0) {
                return false;
            }
        }

        return lower == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
