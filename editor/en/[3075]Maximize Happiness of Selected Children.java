
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0;
        int n = happiness.length;
        int turns = 0;
        int num = 0;

        for (int i = n - 1; i >= n - k; i--) {
            num = happiness[i] - turns;

            if (num > 0) {
                sum += num;
            }

            turns++;
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
