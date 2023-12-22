
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScore(String s) {
        int zeros = 0;
        int ones = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }

            max = Math.max(max, zeros + ones);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
