2214
        Minimum Health to Beat Game
        2023-01-08 23:05:19

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int max = 0;
        long sum = 0;
        for (int num : damage) {
            max = Math.max(max, num);
            sum += (long) num;
        }
        return sum - Math.min(armor, max) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
