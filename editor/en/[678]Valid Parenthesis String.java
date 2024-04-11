
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidString(String s) {
        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
                right++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                }
                right--;
            } else {
                if (left > 0) {
                    left--;
                }
                right++;
            }

            if (right < 0) {
                return false;
            }
        }

        return left == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
