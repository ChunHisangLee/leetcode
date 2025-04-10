
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {

    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        int nextChair = 0;
        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        TreeSet<Integer> availableChairs = new TreeSet<>();

        for (int[] time : times) {
            int arrival = time[0];
            int leave = time[1];

            while (!leavingQueue.isEmpty() && leavingQueue.peek()[0] <= arrival) {
                availableChairs.add(leavingQueue.poll()[1]);
            }

            int currentChair;

            if (!availableChairs.isEmpty()) {
                currentChair = availableChairs.first();
                availableChairs.remove(currentChair);
            } else {
                currentChair = nextChair++;
            }

            leavingQueue.offer(new int[]{leave, currentChair});

            if (arrival == targetArrival) {
                return currentChair;
            }
        }

        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
