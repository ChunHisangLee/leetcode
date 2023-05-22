2402
        Meeting Rooms III
        2022-12-19 13:47:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            pq.add(i);
        }
        PriorityQueue<int[]> pqM = new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] count = new int[n];
        for (int[] meeting : meetings) {
            while (!pqM.isEmpty() && pqM.peek()[0] <= meeting[0]) {
                pq.add(pqM.poll()[1]);
            }
            int delayedStart = meeting[0];
            if (pq.isEmpty()) {
                int[] curr = pqM.poll();
                delayedStart = curr[0];
                pq.add(curr[1]);
            }
            int room = pq.poll();
            count[room]++;
            pqM.add(new int[]{delayedStart + meeting[1] - meeting[0], room});
        }
        int maxIdx = 0;
        for (int r = 0; r < count.length; r++)
            if (count[maxIdx] < count[r])
                maxIdx = r;

        return maxIdx;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
