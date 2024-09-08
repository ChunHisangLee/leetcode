//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int[] slot1 : slots1) {
            if (slot1[1] - slot1[0] >= duration) {
                queue.offer(slot1);
            }
        }

        for (int[] slot2 : slots2) {
            if (slot2[1] - slot2[0] >= duration) {
                queue.offer(slot2);
            }
        }

        while (queue.size() > 1) {
            int[] first = queue.poll();
            int[] second = queue.peek();

            if (first[1] >= second[0] + duration) {
                return Arrays.asList(second[0], second[0] + duration);
            }
        }

        return new ArrayList<>();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
