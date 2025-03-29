
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int count = 1;

        for(int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);

            if(current == sb.charAt(sb.length() - 1)) {
                count++;
            } else {
                count = 1;
            }

            if(count <= 2) {
                sb.append(current);
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
