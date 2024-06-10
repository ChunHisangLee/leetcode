//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int heightChecker(int[] heights) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;

        for (int num : heights) {
            pq.offer(num);
        }

        for (int num : heights) {
            int orderedNum = pq.poll();

            if (num != orderedNum) {
                count++;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
