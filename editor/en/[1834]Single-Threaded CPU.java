1834
        Single-Threaded CPU 2022-12-29 10:12:59

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            sortedTasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(sortedTasks, (a, b) -> a[0] - b[0]);
        int[] taskOrder = new int[n];
        long currTime = 0;
        int taskIndex = 0;
        int resIndex = 0;
        while (taskIndex < n || !pq.isEmpty()) {
            if (pq.isEmpty() && currTime < sortedTasks[taskIndex][0]) {
                currTime = sortedTasks[taskIndex][0];
            }
            while (taskIndex < n && currTime >= sortedTasks[taskIndex][0]) {
                pq.add(sortedTasks[taskIndex]);
                taskIndex++;
            }
            int[] currTask = pq.remove();
            int processTime = currTask[1];
            int index = currTask[2];
            currTime += processTime;
            taskOrder[resIndex] = index;
            resIndex++;
        }
        return taskOrder;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
