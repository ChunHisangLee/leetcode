283
        Move Zeroes
        2022-12-30 22:39:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < n; i++) {
            nums[i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//int[] arr = nums.clone();
//int[] arr = Arrays.copyOf(nums, n);
//int[] arr = Arrays.copyOfRange(nums, 0, n);