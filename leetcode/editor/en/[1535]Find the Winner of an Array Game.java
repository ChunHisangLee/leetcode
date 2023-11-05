
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getWinner(int[] arr, int k) {
        int count = 0;
        int winner = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > winner) {
                winner = arr[i];
                count = 0;
            }

            if (++count == k) {
                break;
            }
        }

        return winner;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
