
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
