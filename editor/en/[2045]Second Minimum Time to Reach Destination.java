//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        int[][] timeArr = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(timeArr[i], Integer.MAX_VALUE);
        }

        deque.offer(new int[]{1, 0});
        timeArr[1][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int node = current[0];
            int currentTime = current[1];
            int nextTime = calculateNextTime(currentTime, time, change);

            for (int nextNode : graph[node]) {
                if (timeArr[nextNode][0] > nextTime) {
                    timeArr[nextNode][1] = timeArr[nextNode][0];
                    timeArr[nextNode][0] = nextTime;
                    deque.offer(new int[]{nextNode, nextTime});
                } else if (timeArr[nextNode][0] < nextTime && timeArr[nextNode][1] > nextTime) {
                    timeArr[nextNode][1] = nextTime;
                    deque.offer(new int[]{nextNode, nextTime});
                }

                if (nextNode == n && timeArr[nextNode][1] < Integer.MAX_VALUE) {
                    return timeArr[nextNode][1];
                }
            }
        }

        return -1;
    }

    private int calculateNextTime(int currentTime, int travelTime, int change) {
        int currentCycle = currentTime / change;

        if (currentCycle % 2 == 0) {
            return currentTime + travelTime;
        } else {
            return (currentCycle + 1) * change + travelTime;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
