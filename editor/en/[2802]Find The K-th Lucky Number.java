
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String kthLuckyNumber(int k) {
        StringBuilder luckyNumber = new StringBuilder();
        final char FOUR = '4';
        final char SEVEN = '7';

        while (k-- > 0) {
            if (k % 2 == 0) {
                luckyNumber.append(FOUR);
            } else {
                luckyNumber.append(SEVEN);
            }

            k /= 2;
        }

        return luckyNumber.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
