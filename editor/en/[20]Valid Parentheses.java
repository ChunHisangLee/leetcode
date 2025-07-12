// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean isValid(String s) {
    if (s.length() % 2 != 0) {
      return false;
    }

    Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
    Deque<Character> stack = new ArrayDeque<>();

    for (char c : s.toCharArray()) {
      if (map.containsKey(c)) {
        if (stack.isEmpty() || stack.pop() != map.get(c)) {
          return false;
        }
      } else {
        stack.push(c);
      }
    }

    return stack.isEmpty();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
