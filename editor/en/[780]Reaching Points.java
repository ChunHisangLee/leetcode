

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            if (tx < ty) {
                ty %= tx;
            } else {
                tx %= ty;
            }
        }
        return sx == tx && (sy <= ty && (ty - sy) % sx == 0) ||
                sy == ty && (sx <= tx && (tx - sx) % sy == 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
