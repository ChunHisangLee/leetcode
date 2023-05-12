//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Deque<Integer> dq = new ArrayDeque<>();
        int sign = 1;
        int res = 0;
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = 10 * num + c - '0';
            } else if (c == '+' || c == '-') {
                res += sign * num;
                num = 0;
                sign = c == '+' ? 1 : -1;
            } else if (c == '(') {
                dq.push(res);
                dq.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * num;
                res = res * dq.pop() + dq.pop();
                num = 0;
            }
        }
        res += sign * num;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
