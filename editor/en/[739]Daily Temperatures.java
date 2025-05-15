//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] ansewer = new int[n];
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]) {
        int index = deque.pop();
        ansewer[index] = i - index;
      }

      deque.push(i);
    }

    return ansewer;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
