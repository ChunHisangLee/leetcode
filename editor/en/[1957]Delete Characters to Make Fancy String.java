
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }

        StringBuilder sb = new StringBuilder(s.substring(0, 2));

        for (int i = 2; i < s.length(); i++) {
            int len = sb.length();

            if (s.charAt(i) != sb.charAt(len - 1) || s.charAt(i) != sb.charAt(len - 2)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
