
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }

            n /= 3;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
