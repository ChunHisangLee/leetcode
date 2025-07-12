
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (!pq.isEmpty() && interval[0] > pq.peek()) {
                pq.poll();
            }

            pq.offer(interval[1]);
        }

        return pq.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
