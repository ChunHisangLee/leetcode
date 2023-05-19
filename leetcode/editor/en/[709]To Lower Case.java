
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toLowerCase(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 'A' && c[i] <= 'Z') {
                c[i] = (char) (c[i] - 'A' + 'a');
            }
        }
        return String.valueOf(c);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
