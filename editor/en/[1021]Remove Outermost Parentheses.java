
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int opened = 0;

        for (char c : s.toCharArray()) {
            if (c == '(' && opened++ > 0) {
                sb.append(c);
            }

            if (c == ')' && opened-- > 1) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
