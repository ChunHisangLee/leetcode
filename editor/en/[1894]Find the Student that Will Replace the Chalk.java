//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = chalk[0];
        IntStream.range(1, n).forEach(i -> prefixSum[i] = prefixSum[i - 1] + chalk[i]);
        final int adjustedK = (int) (k % prefixSum[n - 1]);
        int result = IntStream.range(0, n)
                .filter(i -> prefixSum[i] > adjustedK)
                .findFirst()
                .orElse(-1);

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = chalk[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + chalk[i];
        }

        k = (int) (k % prefixSum[n - 1]);
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prefixSum[mid] <= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
 */