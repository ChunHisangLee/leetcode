
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public int minBuildTime(int[] blocks, int split) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int block : blocks) {
            heap.offer(block);
        }
        while (heap.size() > 1) {
            int block1 = heap.poll();
            int block2 = heap.poll();
            heap.offer(block2 + split);
        }
        return heap.poll();
    }
}

//leetcode submit region end(Prohibit modification and deletion)
