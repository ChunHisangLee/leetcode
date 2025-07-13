
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        int prev = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= prev) {
                return false;
            }

            for (int j = nums[i] - prev - 1; j >= 2; j--) {
                if (isPrime(j)) {
                    nums[i] -= j;
                    break;
                }
            }

            prev = nums[i];
        }

        return true;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
