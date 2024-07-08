
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTheWinner(int n, int k) {
        int winner = 0;

        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }

        return winner + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
