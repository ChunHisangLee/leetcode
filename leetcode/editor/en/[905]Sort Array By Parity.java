905
        Sort Array By Parity
        2023-01-18 21:49:17

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] % 2 == 0) {
                left++;
            } else if (nums[right] % 2 != 0) {
                right--;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }

        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
