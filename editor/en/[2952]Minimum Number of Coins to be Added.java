
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int count = 0;
        int curr = 0;

        for (int coin : coins) {
            while (coin > curr + 1 && curr < target) {
                curr += curr + 1;
                count++;
            }

            curr += coin;

            if (curr >= target) {
                break;
            }
        }

        while (curr < target) {
            curr += curr + 1;
            count++;
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
