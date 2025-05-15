//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            dq.add(c);
        }

        return calc(dq);
    }

    private int calc(Queue<Character> dq) {
        int num = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        char prevOp = '+';

        while (!dq.isEmpty()) {
            char c = dq.poll();

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                num = calc(dq);
            } else if ("+-".indexOf(c) != -1) {
                eval(stack, num, prevOp);
                num = 0;
                prevOp = c;
            } else if (c == ')') {
                break;
            }
        }

        eval(stack, num, prevOp);
        int res = 0;

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public void eval(Deque<Integer> stack, int num, char op) {
        switch (op) {
            case '+' -> stack.push(num);
            case '-' -> stack.push(-num);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
