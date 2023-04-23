75
        Sort Colors
        2022-12-16 14:01:23

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int curr = 0;
        int temp;
        while (curr <= right) {
            if (nums[curr] == 0) {
                temp = nums[curr];
                nums[curr] = nums[left];
                nums[left] = temp;
                left++;
                curr++;
            } else if (nums[curr] == 2) {
                temp = nums[curr];
                nums[curr] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                curr++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
