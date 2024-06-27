// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return IntStream.range(0, nums.length)
                .filter(i -> {
                    int complement = target - nums[i];

                    if (map.containsKey(complement)) {
                        return true;
                    }

                    map.put(nums[i], i);
                    return false;
                })
                .mapToObj(i -> new int[]{map.get(target - nums[i]), i})
                .findFirst()
                .orElse(new int[]{-1, -1});
    }
}
// leetcode submit region end(Prohibit modification and deletion)
