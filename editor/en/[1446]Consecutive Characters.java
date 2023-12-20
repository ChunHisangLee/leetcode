
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPower(String s) {
        char[] c = s.toCharArray();
        int count = 1;
        int max = 0;

        for (int i = 1; i < c.length; i++) {
            max = Math.max(max, count);

            if (c[i] == c[i - 1]) {
                count++;
            } else {
                count = 1;
            }
        }

        return Math.max(max, count);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
