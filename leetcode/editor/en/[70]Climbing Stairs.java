70
        Climbing Stairs
        2022-12-14 15:49:30

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        return dp(n);
    }

    private int dp(int i) {
        if (i <= 2) {
            return i;
        }
        if (!map.containsKey(i)) {
            map.put(i, dp(i - 1) + dp(i - 2));
        }
        return map.get(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
