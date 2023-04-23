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
            int first = pq.remove();
            int second = pq.remove();
            if (first != second)
                pq.add(first - second);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
