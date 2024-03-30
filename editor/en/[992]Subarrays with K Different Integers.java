
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return getMost(nums, k) - getMost(nums, k - 1);
    }

    private int getMost(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int left = 0, right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }

            result += right - left + 1;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
