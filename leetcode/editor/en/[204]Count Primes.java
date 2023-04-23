204
        Count Primes
        2022-12-31 22:22:23

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] nums = new boolean[n];
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (nums[i] == false) {
                for (int j = 2 * i; j < n; j += i) {
                    nums[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] == false) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
