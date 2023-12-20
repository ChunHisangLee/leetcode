
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countBinarySubstrings(String s) {
        char[] c = s.toCharArray();
        int curr = 1;
        int prev = 0;
        int res = 0;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == c[i - 1]) {
                curr++;
            } else {
                res += Math.min(curr, prev);
                prev = curr;
                curr = 1;
            }
        }
        return res + Math.min(curr, prev);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
