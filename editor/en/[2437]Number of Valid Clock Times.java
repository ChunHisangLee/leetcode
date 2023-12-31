
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countTime(String time) {
        int hourCount = 1;
        int minuteCount = 1;
        char c1 = time.charAt(0);
        char c2 = time.charAt(1);
        char c3 = time.charAt(3);
        char c4 = time.charAt(4);

        if (c1 == '?' && c2 == '?') {
            hourCount = 24;
        } else if (c1 == '?') {
            hourCount = c2 < '4' ? 3 : 2;
        } else if (c2 == '?') {
            hourCount = c1 == '2' ? 4 : 10;
        }

        if (c3 == '?') {
            minuteCount *= 6;
        }

        if (c4 == '?') {
            minuteCount *= 10;
        }

        return hourCount * minuteCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
