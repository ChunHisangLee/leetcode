
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int need = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));

        if (need == 0 && t == 1) {
            return false;
        }

        return t >= need;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
