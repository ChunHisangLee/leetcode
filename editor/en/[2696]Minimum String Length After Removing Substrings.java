

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.peek();

                if ((top == 'A' && c == 'B') || (top == 'C' && c == 'D')) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        return stack.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
