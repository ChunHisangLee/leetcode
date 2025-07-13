// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int size = 0;
    int[] tails = new int[n];

    for (int num : nums) {
      int left = 0;
      int right = size;

      while (left < right) {
        int mid = left + (right - left) / 2;

        if (tails[mid] < num) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }

      tails[left] = num;
      if (left == size) {
        size++;
      }
    }

    return size;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
