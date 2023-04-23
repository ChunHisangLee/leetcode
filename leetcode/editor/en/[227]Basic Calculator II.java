227
        Basic Calculator II
        2023-01-31 14:18:14

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int currNum = 0;
        char operator = '+';
        for (int i = 0; i < n; i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNum = (currNum * 10) + (currChar - '0');
            }
            if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == n - 1) {
                if (operator == '+') {
                    stack.push(currNum);
                } else if (operator == '-') {
                    stack.push(-currNum);
                } else if (operator == '*') {
                    stack.push(stack.pop() * currNum);
                } else if (operator == '/') {
                    stack.push(stack.pop() / currNum);
                }
                operator = currChar;
                currNum = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
