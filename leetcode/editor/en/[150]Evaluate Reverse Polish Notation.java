//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                dq.push(Integer.parseInt(token));
            } else {
                int num1 = dq.pop();
                int num2 = dq.pop();
                int res = 0;
                switch (token) {
                    case "+" -> res = num2 + num1;
                    case "-" -> res = num2 - num1;
                    case "*" -> res = num2 * num1;
                    case "/" -> res = num2 / num1;
                }
                dq.push(res);
            }
        }
        return dq.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
