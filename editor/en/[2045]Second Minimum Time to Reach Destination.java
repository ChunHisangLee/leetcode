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

        Deque<int[]> deque = new LinkedList<>();
        int[] visitedNum = new int[n + 1];
        int[][] timeArr = new int[n + 1][2];

        for (int[] arr : timeArr) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        deque.offer(new int[]{1, 0});
        timeArr[1][0] = 0;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int node = cur[0];
            int curTime = cur[1];
            int curLight = curTime / change;
            int nextTime = curLight % 2 == 0 ? curTime + time : (curLight + 1) * change + time;

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
}
//leetcode submit region end(Prohibit modification and deletion)
