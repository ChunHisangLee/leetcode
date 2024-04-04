//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDepth(String s) {
        int current = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                current++;
                max = Math.max(max, current);
            } else if (c == ')') {
                current--;
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
