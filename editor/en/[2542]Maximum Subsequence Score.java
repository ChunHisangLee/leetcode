
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arrs = new int[n][2];
        for (int i = 0; i < n; i++) {
            arrs[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(arrs, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long res = 0;
        long sum = 0;
        for (int[] arr : arrs) {
            pq.add(arr[0]);
            sum += arr[0];
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            if (pq.size() == k) {
                res = Math.max(res, (sum * arr[1]));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
