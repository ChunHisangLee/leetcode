
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums.get(i);
        }
        long res = 0;
        int count = 0;
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);

        for (int num : nums) {
            if (num % modulo == k) {
                count++;
            }
            long remainder = count % modulo;
            if (map.containsKey(remainder)) {
                res += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0L) + 1);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
