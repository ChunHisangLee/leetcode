1046
        Last Stone Weight
        2022-12-09 09:52:02

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            if (first == second) {
                continue;
            }
            pq.add(first - second);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
