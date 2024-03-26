//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustScore = new int[n + 1];

        for (int[] arr : trust) {
            trustScore[arr[0]]--;
            trustScore[arr[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
