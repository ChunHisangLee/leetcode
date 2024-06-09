//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int result = 0;
        map.put(0, 1);

        for (int num : nums) {
            prefixSum += num;
            int afterMod = (prefixSum % k + k) % k;

            if (map.containsKey(afterMod)) {
                result += map.get(afterMod);
            }

            map.put(afterMod, map.getOrDefault(afterMod, 0) + 1);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int[] count = new int[k];
        count[0] = 1;
        int result = 0;

        for (int sum : prefixSum) {
            int afterMod = (sum % k + k) % k;
            result += count[afterMod];
            count[afterMod]++;
        }
        return result;
    }
}
 */