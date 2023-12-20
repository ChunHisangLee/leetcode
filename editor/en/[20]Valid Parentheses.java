20
        Valid Parentheses
        2022-11-29 18:24:11

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                dq.push(c);
            } else {
                if (dq.isEmpty()) {
                    return false;
                }
                char ch = dq.pop();
                if ((ch == '(' && c == ')') || (ch == '[' && c == ']') || (ch == '{' && c == '}')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return dq.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
