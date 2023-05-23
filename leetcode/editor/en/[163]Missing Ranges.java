163
        Missing Ranges
        2023-01-01 09:58:49

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            res.add(Arrays.asList(lower, upper));
            return res;
        }
        if (lower < nums[0]) {
            res.add(Arrays.asList(lower, nums[0] - 1));
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                res.add(Arrays.asList(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (upper > nums[n - 1]) {
            res.add(Arrays.asList(nums[n - 1] + 1, upper));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
