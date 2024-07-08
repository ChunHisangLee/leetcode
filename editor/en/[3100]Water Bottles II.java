//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int result = numBottles;
        int emptyBottle = numBottles;

        while (emptyBottle >= numExchange) {
            emptyBottle -= numExchange;
            result++;
            emptyBottle++;
            numExchange++;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
