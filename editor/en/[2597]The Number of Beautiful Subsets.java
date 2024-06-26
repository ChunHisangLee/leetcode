
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int res = 1;
        int prev = 0;
        int prevPrev = 0;

        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            int cur = e.getKey();

            if (m.containsKey(cur - k)) {
                continue;
            }

            prev = 0;

            while (m.containsKey(cur)) {
                prevPrev = prev;
                prev = ((1 << m.get(cur)) - 1) * res;
                res += prevPrev;
                cur += k;
            }

            res += prev;
        }

        return res - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
