//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String makeGood(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!dq.isEmpty() && Math.abs(dq.peek() - c) == 32) {
                dq.pop();
            } else {
                dq.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!dq.isEmpty()) {
            sb.append(dq.pop());
        }

        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
