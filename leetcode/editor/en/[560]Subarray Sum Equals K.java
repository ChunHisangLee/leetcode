560
        Subarray Sum Equals K
        2022-11-27 20:37:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int res = 0;
        map.put(0, 1);
        for (int num : nums) {
            preSum += num;
            res += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
