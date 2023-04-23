//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int result = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        while (x != 0) {
            int lastDigit = x % 10;
            if (result > max / 10 || (result == max / 10 && lastDigit == 7))
                return 0;
            if (result < min / 10 || (result == min / 10 && lastDigit == -8))
                return 0;
            result = result * 10 + lastDigit;
            x = x / 10;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
