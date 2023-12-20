
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        int sum = 0;
        Arrays.sort(piles);

        for (int i = (n / 3); i < n; i += 2) {
            sum += piles[i];
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
