//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubsequence(String s, int k) {
        long value = 0;
        int bitsSelected = 0;
        int length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '0') {
                length++;
                bitsSelected++;
            } else {
                if (bitsSelected < 31) {
                    long add = 1L << bitsSelected;
                    if (value + add <= k) {
                        value += add;
                        length++;
                        bitsSelected++;
                    }
                }
            }
        }
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
