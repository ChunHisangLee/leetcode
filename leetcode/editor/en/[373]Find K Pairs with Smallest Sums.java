//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new int[]{nums1[i], nums2[0], 1});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            res.add(List.of(curr[0], curr[1]));
            int index = curr[2];
            if (index < nums2.length) {
                pq.add(new int[]{curr[0], nums2[index], index + 1});
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
