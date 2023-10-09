34
        Find First and Last Position of Element in Sorted Array
        2022-12-28 22:44:41

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (nums[mid] == target) {
                int leftIndex = mid;
                int rightIndex = mid;

                while (leftIndex >= 0 && nums[leftIndex] == target) {
                    leftIndex--;
                }

                while (rightIndex < nums.length && nums[rightIndex] == target) {
                    rightIndex++;
                }

                return new int[]{leftIndex + 1, rightIndex - 1};

            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
