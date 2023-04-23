//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int index;

    public int calculate(String s) {
        index = 0;
        return calc(s);
    }

    private int calc(String s) {
        int res = 0;
        int num = 0;
        int sign = 1;
        while (index < s.length()) {
            char ch = s.charAt(index++);
            if (ch >= '0' && ch <= '9')
                num = num * 10 + ch - '0';
            else if (ch == '(')
                num = calc(s);
            else if (ch == ')')
                return res + sign * num;
            else if (ch == '+' || ch == '-') {
                res += sign * num;
                num = 0;
                sign = ch == '-' ? -1 : 1;
            }
        }
        return res + sign * num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
