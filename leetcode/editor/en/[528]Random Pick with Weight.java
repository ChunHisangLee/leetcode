
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] prefixSum;
    int total;

    public Solution(int[] w) {
        int n = w.length;
        prefixSum = new int[n];
        total = 0;
        for (int i = 0; i < n; i++) {
            total += w[i];
            prefixSum[i] = total;
        }
    }

    public int pickIndex() {
        double target = total * Math.random();
        int left = 0;
        int right = prefixSum.length;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)
