283
        Move Zeroes
        2022-12-30 22:39:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int[] arr = nums.clone();
        Arrays.fill(nums,0);
        int index = 0;
        for (int i = 0; i <  nums.length; i++) {
            if (arr[i] != 0) {
                nums[index] = arr[i];
                index++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//int[] arr = nums.clone();
//int[] arr = Arrays.copyOf(nums, n);
//int[] arr = Arrays.copyOfRange(nums, 0, n);