20
Valid Parentheses
        2022-11-29 18:24:11

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                deque.push(c);
            } else {
                if (deque.isEmpty() || !isMatch(deque.pop(), c)) {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }

    private boolean isMatch(char first, char second) {
        return (first == '(' && second == ')') || (first == '[' && second == ']') || (first == '{' && second == '}');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
