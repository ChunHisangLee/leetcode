
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        StringBuilder sb = new StringBuilder(s);
        sb.append(s);
        return sb.toString().contains(goal);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
