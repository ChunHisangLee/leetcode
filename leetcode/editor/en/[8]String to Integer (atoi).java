8
        String to Integer(atoi)
        2023-01-02 00:23:37

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        char[] c = s.toCharArray();
        int n = c.length;
        int index = 0;
        int sign = 1;
        double res = 0;
        if (index < n && c[index] == '+') {
            index++;
        } else if (index < n && c[index] == '-') {
            sign = -1;
            index++;
        }
        while (index < n && Character.isDigit(c[index])) {
            res = res * 10 + (c[index] - '0');
            index++;
        }
        if (res > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
