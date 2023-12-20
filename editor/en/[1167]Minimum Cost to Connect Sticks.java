1167
        Minimum Cost to Connect Sticks
        2022-12-09 15:12:46

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int stick : sticks) {
            heap.offer(stick);
        }
        int res = 0;
        while (heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();
            int sum = first + second;
            res += sum;
            heap.offer(sum);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
