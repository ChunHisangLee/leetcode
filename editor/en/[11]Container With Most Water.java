11
        Container With Most Water
        2022-11-23 22:39:25

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int currH = Math.min(height[left], height[right]);
            res = Math.max(res, (right - left) * currH);
            while (left < right && height[left] <= currH) {
                left++;
            }
            while (left < right && height[right] <= currH) {
                right--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
