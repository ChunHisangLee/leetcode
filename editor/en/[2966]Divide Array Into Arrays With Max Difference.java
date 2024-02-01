//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i += 3) {
            if (nums[i + 2] - nums[i] <= k) {
                list.add(new int[]{nums[i], nums[i + 1], nums[i + 2]});
            } else {
                return new int[][]{};
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
