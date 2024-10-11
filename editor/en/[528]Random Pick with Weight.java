
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private long[] prefixSum;
    private long total;
    private Random random;

    public Solution(int[] w) {
        int n = w.length;
        prefixSum = new long[n];
        total = 0;

        for (int i = 0; i < n; i++) {
            total += w[i];
            prefixSum[i] = total;
        }

        random = new Random();
    }

    public int pickIndex() {
        long target = getRandomTarget();
        int index = Arrays.binarySearch(prefixSum, target);

        if (index < 0) {
            index = -index - 1;
        }

        return index;
    }

    private long getRandomTarget() {
        return (long) (random.nextDouble() * total) + 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)
