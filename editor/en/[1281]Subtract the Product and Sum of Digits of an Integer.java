
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subtractProductAndSum(int n) {
        int mod = 0;
        int prod = 1;
        int sum = 0;
        while (n > 0) {
            mod = n % 10;
            prod *= mod;
            sum += mod;
            n /= 10;
        }
        return prod - sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
