
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = wage.length;
        double[][] arrs = new double[n][2];
        for (int i = 0; i < n; i++) {
            arrs[i] = new double[]{(double) quality[i], (double) (wage[i]) / quality[i]};
        }
        Arrays.sort(arrs, (a, b) -> Double.compare(a[1], b[1]));
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double res = Double.MAX_VALUE;
        double sum = 0;
        for (double[] arr : arrs) {
            pq.add(arr[0]);
            sum += arr[0];
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            if (pq.size() == k) {
                res = Math.min(res, sum * arr[1]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
