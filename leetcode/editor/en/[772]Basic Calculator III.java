/*
https://leetcode.com/problems/basic-calculator-iii/solutions/113592/Development-of-a-generic-solution-for-the-series-of-the-calculator-problems/
https://leetcode.com/problems/basic-calculator-iii/solutions/1727380/java-this-simple-template-can-be-used-for-basic-calculator-i-ii-iii/?languageTags=java
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            dq.add(c);
        }
        return calc(dq);
    }

    public int calc(Deque<Character> dq) {
        int num = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        char prevOp = '+';
        while (!dq.isEmpty()) {
            char c = dq.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                num = calc(dq);
            } else if ("+-*/".indexOf(c) != -1) {
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
            case '*' -> stack.push(stack.pop() * num);
            case '/' -> stack.push(stack.pop() / num);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
