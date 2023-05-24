
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arrs = new int[n][2];
        for (int i = 0; i < n; i++) {
            arrs[i] = new int[]{speed[i], efficiency[i]};
        }
        Arrays.sort(arrs, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long MOD = (long) 1e9 + 7;
        long res = 0;
        long sum = 0;
        for (int[] arr : arrs) {
            pq.add(arr[0]);
            sum += arr[0];
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            res = Math.max(res, sum * arr[1]);
        }
        return (int) (res % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
