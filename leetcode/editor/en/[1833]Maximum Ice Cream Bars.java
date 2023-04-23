1833
        Maximum Ice Cream Bars
        2023-01-06 09:25:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int cost : costs) {
            if (coins >= cost) {
                coins -= cost;
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
