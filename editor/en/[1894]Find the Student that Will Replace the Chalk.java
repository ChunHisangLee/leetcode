//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long totalChalk = 0;

        for (int num : chalk) {
            totalChalk += num;
        }

        k %= totalChalk;

        for (int i = 0; i < n; i++) {
            if (k < chalk[i]) {
                return i;
            }

            k -= chalk[i];
        }

        return -1;
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
