//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        int emptyBottle = numBottles;

        while (emptyBottle >= numExchange) {
            int newBottle = emptyBottle / numExchange;
            result += newBottle;
            emptyBottle = newBottle + (emptyBottle % numExchange);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
