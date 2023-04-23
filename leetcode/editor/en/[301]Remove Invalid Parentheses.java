//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> list = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        remove(s, 0, 0, new char[]{'(', ')'});
        return list;
    }

    private void remove(String s, int x, int y, char[] pair) {
        int count = 0;
        for (int i = x; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == pair[0]) {
                count++;
            } else if (c == pair[1]) {
                count--;
            }
            if (count < 0) {
                for (int j = y; j <= i; j++) {
                    if (s.charAt(j) == pair[1] && (j == y || s.charAt(j - 1) != pair[1])) {
                        remove(s.substring(0, j) + s.substring(j + 1), i, j, pair);
                    }
                }
                return;
            }
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            remove(reversed, 0, 0, new char[]{')', '('});
        } else {
            list.add(reversed);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
