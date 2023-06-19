153
        Find Minimum in Rotated Sorted Array
        2022-12-29 12:30:46

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] >= nums[left] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
