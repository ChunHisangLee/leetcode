2294
        Partition Array Such That Maximum Difference Is K
        2022-12-10 14:56:18

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - x > k) {
                x = nums[i];
                res++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
