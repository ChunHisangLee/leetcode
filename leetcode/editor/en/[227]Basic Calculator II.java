227
        Basic Calculator II
        2023-01-31 14:18:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        int n = s.length();
        int curr = 0;
        int lastNum = 0;
        int res = 0;
        char operator = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                switch (operator) {
                    case '+':
                        res += lastNum;
                        lastNum = curr;
                        break;
                    case '-':
                        res += lastNum;
                        lastNum = -curr;
                        break;
                    case '*':
                        lastNum *= curr;
                        break;
                    case '/':
                        lastNum /= curr;
                        break;
                }
                operator = c;
                curr = 0;
            }
        }
        res += lastNum;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
