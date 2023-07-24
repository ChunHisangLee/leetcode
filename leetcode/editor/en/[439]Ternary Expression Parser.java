
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String parseTernary(String expression) {
        if (expression.length() == 1) {
            return expression;
        }
        int index = 0;
        int count = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '?') {
                count++;
            } else if (c == ':') {
                count--;
                if (count == 0) {
                    index = i;
                    break;
                }
            }
        }
        return expression.charAt(0) == 'T' ? parseTernary(expression.substring(2, index)) : parseTernary(expression.substring(index + 1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
- 7 ms
class Solution {
    public String parseTernary(String expression) {
        char[] c = expression.toCharArray();
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == '?') {
                char first = dq.pop();
                char second = dq.pop();
                if (c[i - 1] == 'T') {
                    dq.push(first);
                } else if (c[i - 1] == 'F') {
                    dq.push(second);
                }
                i--;
            } else if (c[i] == ':') {
                continue;
            } else {
                dq.push(c[i]);
            }
        }
        return String.valueOf(dq.pop());
    }
}
 */