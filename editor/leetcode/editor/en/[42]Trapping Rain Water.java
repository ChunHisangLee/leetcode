// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int trap(int[] height) {
    int leftIndex = 0;
    int rightIndex = height.length - 1;
    int leftMax = 0;
    int rightMax = 0;
    int water = 0;

    while (leftIndex < rightIndex) {
      if (height[leftIndex] <= height[rightIndex]) {
        if (height[leftIndex] >= leftMax) {
          leftMax = height[leftIndex];
        } else {
          water += (leftMax - height[leftIndex]);
        }

        leftIndex++;
      } else {
        if (height[rightIndex] >= rightMax) {
          rightMax = height[rightIndex];
        } else {
          water += (rightMax - height[rightIndex]);
        }

        rightIndex--;
      }
    }

    return water;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
