// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int trap(int[] height) {
    int leftIndex = 0;
    int rightIndex = height.length - 1;
    int leftMaxHeight = 0;
    int rightMaxHeight = 0;
    int result = 0;

    while (leftIndex < rightIndex) {
      if (height[leftIndex] <= height[rightIndex]) {
        if (height[leftIndex] >= leftMaxHeight) {
          leftMaxHeight = height[leftIndex];
        } else {
          result += (leftMaxHeight - height[leftIndex]);
            }

        leftIndex++;
      } else {
        if (height[rightIndex] >= rightMaxHeight) {
          rightMaxHeight = height[rightIndex];
        } else {
          result += (rightMaxHeight - height[rightIndex]);
        }

        rightIndex--;
        }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
