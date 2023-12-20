1
        Two Sum
        2022-11-25 09:36:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                return new int[]{map.get(nums[i]), i};
            }
        }
        return new int[]{-1, -1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

