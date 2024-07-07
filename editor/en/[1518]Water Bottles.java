//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrunk = numBottles;
        int emptyBottle = numBottles;

        while (emptyBottle >= numExchange) {
            int newFullBottle = emptyBottle / numExchange;
            totalDrunk += newFullBottle;
            emptyBottle = newFullBottle + (emptyBottle % numExchange);
        }

        return totalDrunk;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
