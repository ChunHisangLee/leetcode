
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestBeautifulSubstring(String word) {
        char[] c = word.toCharArray();
        int count = 1;
        int index = 1;
        int res = 0;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == c[i - 1]) {
                count++;
            } else if (c[i] > c[i - 1]) {
                count++;
                index++;
            } else {
                count = 1;
                index = 1;
            }
            if (index == 5) {
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
