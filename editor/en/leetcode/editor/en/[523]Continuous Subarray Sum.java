
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int prefixSum = 0;
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            int afterMod = prefixSum % k;

            if (map.containsKey(afterMod)) {
                if (i - map.get(afterMod) > 1) {
                    return true;
                }
            } else {
                map.put(afterMod, i);
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
