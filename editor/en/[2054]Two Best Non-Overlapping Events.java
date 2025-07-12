
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int max = 0;
        int result = 0;

        for (int i = 0; i < events.length; i++) {
            int currentStart = events[i][0];
            int currentValue = events[i][2];

            while (!pq.isEmpty() && pq.peek()[1] < currentStart) {
                max = Math.max(max, pq.poll()[2]);
            }

            result = Math.max(result, max + currentValue);
            result = Math.max(result, currentValue);
            pq.offer(events[i]);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
