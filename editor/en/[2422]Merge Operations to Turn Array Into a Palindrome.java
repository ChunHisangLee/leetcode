//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] < nums[right]) {
                nums[left + 1] += nums[left];
                count++;
                left++;
            } else {
                nums[right - 1] += nums[right];

                right--;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
