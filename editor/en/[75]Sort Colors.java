//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public void sortColors(int[] nums) {
    int left = 0;
    int index = 0;
    int right = nums.length - 1;

    while (index <= right) {
      if (nums[index] == 2) {
        swap(nums, index, right);
        right--;
      } else if (nums[index] == 0) {
        swap(nums, index, left);
        left++;
        index++;
      } else {
        index++;
      }
    }
  }

  private void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
