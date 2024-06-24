
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = IntStream.range(0, n)
                .parallel()
                .mapToObj(i -> new int[]{difficulty[i], profit[i]})
                .sorted((a, b) -> a[0] - b[0])
                .toArray(int[][]::new);
        Arrays.sort(worker);
        int maxProfit = 0;
        int totalProfit = 0;
        int index = 0;

        for (int skill : worker) {
            while (index < n && jobs[index][0] <= skill) {
                maxProfit = Math.max(maxProfit, jobs[index][1]);
                index++;
            }

            totalProfit += maxProfit;
        }

        return totalProfit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
