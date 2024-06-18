
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] job = new int[n][2];

        for (int i = 0; i < n; i++) {
            job[i][0] = difficulty[i];
            job[i][1] = profit[i];
        }

        Arrays.sort(job, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        int maxProfit = 0;
        int totalProfit = 0;
        int index = 0;

        for (int skill : worker) {
            while (index < n && job[index][0] <= skill) {
                maxProfit = Math.max(maxProfit, job[index][1]);
                index++;
            }

            totalProfit += maxProfit;
        }

        return totalProfit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
