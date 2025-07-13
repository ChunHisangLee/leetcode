// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maxArea(int[] height) {
    int result = 0;
    int left = 0;
    int right = height.length - 1;

    while (left < right) {
      int width = Math.min(height[left], height[right]);
      int length = right - left;
      int currentArea = width * length;
      result = Math.max(result, currentArea);

      while (left < right && height[left] <= width) {
        left++;
      }

      while (left < right && height[right] <= width) {
        right--;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
