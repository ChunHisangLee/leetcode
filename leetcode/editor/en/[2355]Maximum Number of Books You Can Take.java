
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumBooks(int[] books) {
        int n = books.length;
        Deque<Integer> dq = new ArrayDeque<>();
        long[] dp = new long[n];
        long max = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && books[dq.peek()] - dq.peek() >= books[i] - i) {
                dq.pop();
            }

            if (dq.isEmpty()) {
                dp[i] = getSum(books, 0, i);
            } else {
                int j = dq.peek();
                dp[i] = dp[j] + getSum(books, j + 1, i);
            }

            dq.push(i);
        }

        for (long num : dp) {
            max = Math.max(max, num);
        }
        return max;
    }

    private long getSum(int[] books, int left, int right) {
        long count = Math.min(books[right], right - left + 1);
        return (2 * books[right] - (count - 1)) * count / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
