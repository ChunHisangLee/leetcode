84
        Largest Rectangle in Histogram
        2022-12-26 00:18:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(-1);
        int n = heights.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            while ((dq.peek() != -1) && (heights[dq.peek()] >= heights[i])) {
                int currH = heights[dq.pop()];
                int currW = i - dq.peek() - 1;
                max = Math.max(max, currH * currW);
            }
            dq.push(i);
        }
        while (dq.peek() != -1) {
            int currH = heights[dq.pop()];
            int currW = n - dq.peek() - 1;
            max = Math.max(max, currH * currW);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
