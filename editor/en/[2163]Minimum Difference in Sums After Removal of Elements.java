
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public long minimumDifference(int[] nums) {
        final int total = nums.length;
        final int n = total / 3;

        long[] leftMin = new long[total];
        long[] rightMax = new long[total];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long sumL = 0;
        for (int i = 0; i < total; i++) {
            maxHeap.offer(nums[i]);
            sumL += nums[i];
            if (maxHeap.size() > n) {
                sumL -= maxHeap.poll();
            }
            leftMin[i] = (maxHeap.size() == n) ? sumL : Long.MAX_VALUE / 4;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumR = 0;
        for (int i = total - 1; i >= 0; i--) {
            minHeap.offer(nums[i]);
            sumR += nums[i];
            if (minHeap.size() > n) {
                sumR -= minHeap.poll();
            }
            rightMax[i] = (minHeap.size() == n) ? sumR : Long.MIN_VALUE / 4;
        }

        long ans = Long.MAX_VALUE;
        for (int i = n - 1; i <= 2 * n - 1; i++) {
            long diff = leftMin[i] - rightMax[i + 1];
            ans = Math.min(ans, diff);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
