215
        Kth Largest Element in an Array
        2022-12-09 14:55:35

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
