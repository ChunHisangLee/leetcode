
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    trappedWater += maxLeft - height[left];
                }

                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    trappedWater += maxRight - height[right];
                }

                right--;
            }
        }

        return trappedWater;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
