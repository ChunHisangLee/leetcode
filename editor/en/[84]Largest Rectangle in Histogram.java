//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int maxArea = 0;
    Deque<Integer> deque = new ArrayDeque<>();
    deque.push(-1);

    for (int i = 0; i < n; i++) {
      while (deque.peek() != -1 && heights[i] < heights[deque.peek()]) {
        int height = heights[deque.pop()];
        int width = i - deque.peek() - 1;
        maxArea = Math.max(maxArea, height * width);
      }

      deque.push(i);
    }

    while (deque.peek() != -1) {
      int height = heights[deque.pop()];
      int width = n - deque.peek() - 1;
      maxArea = Math.max(maxArea, height * width);
    }

    return maxArea;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
