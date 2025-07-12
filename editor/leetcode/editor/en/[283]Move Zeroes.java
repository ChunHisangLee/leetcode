// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public void moveZeroes(int[] nums) {
    int n = nums.length;
    int index = 0;

    for (int i = 0; i < n; i++) {
      if (nums[i] != 0) {
        if (i != index) {
          int temp = nums[i];
          nums[i] = nums[index];
          nums[index] = temp;
        }

        index++;
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
