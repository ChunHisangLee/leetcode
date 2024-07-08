//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int passThePillow(int n, int time) {
        int effectiveTime = time % (2 * (n - 1));

        if (effectiveTime < n) {
            return effectiveTime + 1;
        } else {
            return 2 * n - 1 - effectiveTime;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
