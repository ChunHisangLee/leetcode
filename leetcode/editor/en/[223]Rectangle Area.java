//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2) + Math.abs(bx1 - bx2) * Math.abs(by1 - by2);
        int x = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int y = Math.min(ay2, by2) - Math.max(ay1, by1);
        int repeat = 0;
        if (x > 0 && y > 0)
            repeat = x * y;
        return area - repeat;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
