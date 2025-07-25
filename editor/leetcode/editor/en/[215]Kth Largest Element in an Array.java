// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int num : nums) {
      if (minHeap.size() < k) {
        minHeap.offer(num);
      } else {
        if (num > minHeap.peek()) {
          minHeap.poll();
          minHeap.offer(num);
        }
      }
    }

    return minHeap.poll();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
