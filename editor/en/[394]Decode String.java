// 394
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        Deque<Integer> digit = new ArrayDeque<>();
        int num = 0;
        //String curr = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i++) - '0');
                }
                i--;
            } else if (ch == '[') {
                stack.offerLast(sb.toString());
                digit.offerLast(num);
                sb = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                String curr = sb.toString();
                int repeat = digit.pollLast();
                StringBuilder currSb = new StringBuilder(stack.pollLast());
                while (repeat-- > 0) {
                    currSb.append(curr);
                }
                sb = currSb;
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
