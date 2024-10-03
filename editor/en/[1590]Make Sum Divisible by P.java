
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;

        for (int num : nums) {
            total += num;
        }

        long r = total % p;

        if (r == 0) {
            return 0;
        }

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        long prefix = 0;
        int n = nums.length;
        int min = n;

        for (int i = 0; i < n; i++) {
            prefix = (prefix + nums[i]) % p;
            long need = (prefix - r + p) % p;

            if (map.containsKey(need)) {
                min = Math.min(min, i - map.get(need));

                if (min == 1) {
                    return 1;
                }
            }

            map.put(prefix, i);
        }

        return min == n ? -1 : min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
