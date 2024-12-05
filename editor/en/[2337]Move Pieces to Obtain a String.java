
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0;
        int j = 0;

        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }

            while (j < n && target.charAt(j) == '_') {
                j++;
            }

            if (i == n && j == n) {
                return true;
            }

            if ((i == n) != (j == n)) {
                return false;
            }

            char s = start.charAt(i);
            char t = target.charAt(j);

            if (s != t) {
                return false;
            }

            if (s == 'L') {
                if (i < j) {
                    return false;
                }
            } else {
                if (i > j) {
                    return false;
                }
            }

            i++;
            j++;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
