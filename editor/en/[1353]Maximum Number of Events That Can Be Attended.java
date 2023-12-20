
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = events.length;
        int res = 0;
        int i = 0;
        int d = 0;
        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                d = events[i][0];
            }
            while (i < n && events[i][0] == d) {
                pq.add(events[i++][1]);
            }
            pq.poll();
            res++;
            d++;
            while (!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
