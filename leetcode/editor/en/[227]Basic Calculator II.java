227
        Basic Calculator II
        2023-01-31 14:18:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char prevOp = '+';
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if ("+-*/".indexOf(c) != -1) {
                eval(stack, num, prevOp);
                num = 0;
                prevOp = c;
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
            case '*' -> stack.push(stack.pop() * num);
            case '/' -> stack.push(stack.pop() / num);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
