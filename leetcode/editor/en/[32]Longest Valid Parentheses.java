32
        Longest Valid Parentheses
        2023-01-01 09:46:05

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(-1);
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                dq.push(i);
            } else {
                dq.pop();
                if (dq.isEmpty()) {
                    dq.push(i);
                } else {
                    max = Math.max(max, i - dq.peek());
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
