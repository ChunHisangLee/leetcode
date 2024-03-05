
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rotatedDigits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (isValid(i)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValid(int num) {
        boolean flag = false;

        while (num > 0) {
            int digit = num % 10;

            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            } else if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                flag = true;
            }

            num /= 10;
        }

        return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
