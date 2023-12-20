739
        Daily Temperatures
        2022-11-30 09:58:19

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] arr = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && temperatures[dq.peek()] < temperatures[i]) {
                int prev = dq.pop();
                arr[prev] = i - prev;
            }
            dq.push(i);
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
