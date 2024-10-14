
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[n];
        int count = 0;
        dp[count++] = envelopes[0][1];

        for (int i = 1; i < n; i++) {
            if (dp[count - 1] < envelopes[i][1]) {
                dp[count++] = envelopes[i][1];
            } else {
                int index = binarySearch(dp, 0, count - 1, envelopes[i][1]);
                dp[index] = envelopes[i][1];
            }
        }

        return count;
    }

    private int binarySearch(int[] dp, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >> 1;

            if (dp[mid] == target) {
                return mid;
            } else if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
