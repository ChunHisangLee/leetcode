
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
    Deque<Integer> deque = new ArrayDeque<>();
    int maxLength = 0;
    int n = s.length();
    deque.push(-1);

    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);

      if (c == '(') {
        deque.push(i);
      } else {
        deque.pop();

        if (deque.isEmpty()) {
          deque.push(i);
        } else {
          maxLength = Math.max(maxLength, i - deque.peek());
        }
      }
    }

    return maxLength;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
