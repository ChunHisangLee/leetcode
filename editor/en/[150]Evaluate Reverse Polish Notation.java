//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                dq.push(Integer.parseInt(token));
            } else {
                int num2 = dq.pop();
                int num1 = dq.pop();

                switch (token) {
                    case "+" -> dq.push(num1 + num2);
                    case "-" -> dq.push(num1 - num2);
                    case "*" -> dq.push(num1 * num2);
                    case "/" -> dq.push(num1 / num2);
                }
            }
        }

        return dq.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
