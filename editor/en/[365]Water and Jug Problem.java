
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) {
            return false;
        }
        return targetCapacity % gdc(jug1Capacity, jug2Capacity) == 0;
    }

    public int gdc(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
