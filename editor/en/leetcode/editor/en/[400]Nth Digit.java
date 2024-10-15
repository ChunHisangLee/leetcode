
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        int digitLength = 1;
        long count = 9;
        long start = 1;

        while (n > digitLength * count) {
            n -= digitLength * count;
            digitLength++;
            count *= 10;
            start *= 10;
        }

        long number = start + (n - 1) / digitLength;
        int digitIndex = (n - 1) % digitLength;
        String numberStr = String.valueOf(number);
        return Character.getNumericValue(numberStr.charAt(digitIndex));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
