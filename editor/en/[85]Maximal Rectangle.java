
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[n];
        int res = 0;
        for (char[] c : matrix) {
            for (int i = 0; i < n; i++) {
                arr[i] = c[i] == '0' ? 0 : arr[i] + 1;
            }
            res = Math.max(res, largestRectangleArea(arr));
        }
        return res;
    }

    private int largestRectangleArea(int[] heights) {
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
