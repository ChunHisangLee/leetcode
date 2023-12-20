844
        Backspace String Compare
        2022-11-23 22:54:02

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        s = build(s);
        t = build(t);

        return s.equals(t);
    }

    public String build(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                count++;
            } else if (count != 0) {
                count--;
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public boolean backspaceCompare(String s, String t) {
        s = build(s);
        t = build(t);

        return s.equals(t);
    }

    public String build(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c != '#') {
                deque.push(c);
            } else if (!deque.isEmpty()) {
                deque.pop();
            }
        }

        return String.valueOf(deque);
    }
}
 */