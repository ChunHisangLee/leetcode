
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final int MOD = (int) 1e9 + 7;

    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;

        for (int num : nums) {
            int key = num - rev(num);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int val : map.values()) {
            count = (count + (long) val * (val - 1) / 2) % MOD;
        }

        return (int) count;
    }

    private int rev(int x) {
        int result = 0;

        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
