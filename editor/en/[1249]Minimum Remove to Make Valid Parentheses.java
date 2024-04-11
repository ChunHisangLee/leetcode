//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                dq.push(i);
            } else if (sb.charAt(i) == ')') {
                if (!dq.isEmpty()) {
                    dq.pop();
                } else {
                    sb.setCharAt(i, '*');
                }
            }
        }

        while (!dq.isEmpty()) {
            sb.setCharAt(dq.pop(), '*');
        }

        return sb.toString().replaceAll("\\*", "");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
