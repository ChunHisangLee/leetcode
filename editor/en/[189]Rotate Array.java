// 189
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] numToShift = new int[k];
        for (int i = 0; i < k; i++) {
            numToShift[i] = nums[nums.length - k + i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i >= k)
                nums[i] = nums[i - k];
            else
                nums[i] = numToShift[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
