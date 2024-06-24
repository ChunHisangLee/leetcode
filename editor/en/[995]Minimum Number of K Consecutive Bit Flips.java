
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int currentFlips = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k && nums[i - k] > 1) {
                currentFlips ^= 1;
                nums[i - k] -= 2;
            }

            if ((nums[i] ^ currentFlips) == 0) {
                if (i + k > n) {
                    return -1;
                }

                flips++;
                currentFlips ^= 1;
                nums[i] += 2;
            }
        }

        return flips;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
