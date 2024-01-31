//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : num.toCharArray()) {
            while (!deque.isEmpty() && k > 0 && deque.peek() > c) {
                deque.pop();
                k--;
            }

            deque.push(c);
        }

        while (k > 0) {
            deque.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            sb.append(deque.removeLast());
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
