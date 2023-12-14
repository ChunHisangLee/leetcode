
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSegments(String s) {
        s = s.trim();

        if ("".equals(s)) {
            return 0;
        }

        return s.split("\\s+").length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
