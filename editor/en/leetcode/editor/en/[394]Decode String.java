// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public String decodeString(String s) {
    Deque<Integer> numDeque = new ArrayDeque<>();
    Deque<String> strDeque = new ArrayDeque<>();
    int currNum = 0;
    StringBuilder currStr = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        currNum = currNum * 10 + (c - '0');
      } else if (c == '[') {
        numDeque.push(currNum);
        strDeque.push(currStr.toString());
        currNum = 0;
        currStr.setLength(0);
      } else if (c == ']') {
        int count = numDeque.pop();
        StringBuilder sb = new StringBuilder(strDeque.pop());

        for (int i = 0; i < count; i++) {
          sb.append(currStr);
        }

        currStr = sb;
      } else {
        currStr.append(c);
      }
    }

    return currStr.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
