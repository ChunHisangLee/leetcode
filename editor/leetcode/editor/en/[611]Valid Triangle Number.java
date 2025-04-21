// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int triangleNumber(int[] nums) {
    int n = nums.length;

    if (n < 3) {
      return 0;
    }

    int count = 0;
    Arrays.sort(nums);

    for (int i = n - 1; i >= 0; i--) {
      int left = 0;
      int right = i - 1;

      while (left < right) {
        if (nums[left] + nums[right] > nums[i]) {
          count += (right - left);
          right--;
        } else {
          left++;
        }
      }
    }

    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
