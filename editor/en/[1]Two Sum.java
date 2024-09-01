// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];

            if (!map.containsKey(complement)) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(complement), i};
            }
        }

        return new int[]{-1, -1};
    }
}
// leetcode submit region end(Prohibit modification and deletion)
