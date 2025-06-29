// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public void sortColors(int[] nums) {
    int zeroIndex = 0;
    int currIndex = 0;
    int twoIndex = nums.length - 1;

    while (currIndex <= twoIndex) {
      if (nums[currIndex] == 0) {
        swap(nums, currIndex, zeroIndex);
        currIndex++;
        zeroIndex++;
      } else if (nums[currIndex] == 2) {
        swap(nums, currIndex, twoIndex);
        twoIndex--;
      } else {
        currIndex++;
      }
    }
  }

  private void swap(int[] nums, int x, int y) {
    int temp = nums[x];
    nums[x] = nums[y];
    nums[y] = temp;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
