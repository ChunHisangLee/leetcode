
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            maxHeap.offer(num);
        }

        long score = 0;

        for (int i = 0; i < k; i++) {
            int currentMax = maxHeap.poll();
            score += currentMax;
            int newVal = (currentMax + 2) / 3;
            maxHeap.offer(newVal);
        }

        return score;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
