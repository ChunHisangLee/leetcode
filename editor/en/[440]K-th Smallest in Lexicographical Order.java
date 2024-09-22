
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;

        while (k > 0) {
            long steps = calculateSteps(n, current, current + 1);

            if (steps <= k) {
                current += 1;
                k -= steps;
            } else {
                current *= 10;
                k -= 1;
            }
        }

        return current;
    }

    private long calculateSteps(int n, long first, long last) {
        long steps = 0;

        while (first <= n) {
            steps += Math.min((long) n + 1, last) - first;
            first *= 10;
            last *= 10;
        }
        return steps;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
