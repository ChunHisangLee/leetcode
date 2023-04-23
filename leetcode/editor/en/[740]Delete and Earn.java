740
        Delete and Earn
        2023-02-20 10:46:32

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> point = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
            max = Math.max(max, num);
        }
        return dp(max);
    }

    private int dp(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return map.getOrDefault(n, 0);
        }
        if (!point.containsKey(n)) {
            point.put(n, Math.max(dp(n - 1), dp(n - 2) + map.getOrDefault(n, 0)));
        }
        return point.get(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
