// leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {
  Deque<Integer> inStack;
  Deque<Integer> outStack;

  public MyQueue() {
    inStack = new ArrayDeque<>();
    outStack = new ArrayDeque<>();
  }

  public void push(int x) {
    inStack.push(x);
  }

  public int pop() {
    moveIntoOutIfNeeded();
    return outStack.pop();
  }

  public int peek() {
    moveIntoOutIfNeeded();
    return outStack.peek();
  }

  public boolean empty() {
    if (inStack.isEmpty() && outStack.isEmpty()) {
      return true;
    }

    return false;
  }

  private void moveIntoOutIfNeeded() {
    if (outStack.isEmpty()) {
      while (!inStack.isEmpty()) {
        outStack.push(inStack.pop());
      }
    }
  }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj = new MyQueue();
 * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.peek(); boolean param_4 = obj.empty();
 */
// leetcode submit region end(Prohibit modification and deletion)
