//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int evalRPN(String[] tokens) {
    Deque<Integer> deque = new ArrayDeque<>();
    int x = 0;
    int y = 0;

    for (String token : tokens) {
      switch (token) {
        case "+" -> {
          y = deque.pop();
          x = deque.pop();
          deque.push(x + y);
        }
        case "-" -> {
          y = deque.pop();
          x = deque.pop();
          deque.push(x - y);
        }
        case "*" -> {
          y = deque.pop();
          x = deque.pop();
          deque.push(x * y);
        }
        case "/" -> {
          y = deque.pop();
          x = deque.pop();
          deque.push(x / y);
        }
        default -> deque.push(Integer.parseInt(token));
      }
    }

    return deque.pop();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
