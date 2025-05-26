// leetcode submit region begin(Prohibit modification and deletion)
/** Stack implementation using a single queue. */
public class MyStack {
  private final Queue<Integer> queue;

  /** Initialize your data structure here. */
  public MyStack() {
    queue = new LinkedList<>();
  }

  /**
   * Push element x onto stack.
   *
   * @param x the element to push
   */
  public void push(int x) {
    queue.offer(x);
    // Rotate the queue to move the new element to the front
    int sz = queue.size();
    for (int i = 0; i < sz - 1; i++) {
      queue.offer(queue.poll());
    }
  }

  /**
   * Removes the element on top of the stack and returns that element.
   *
   * @return the top element
   */
  public int pop() {
    return queue.isEmpty() ? -1 : queue.poll();
  }

  /**
   * Get the top element.
   *
   * @return the top element without removing it
   */
  public int top() {
    return queue.isEmpty() ? -1 : queue.peek();
  }

  /**
   * Returns whether the stack is empty.
   *
   * @return true if empty, false otherwise
   */
  public boolean empty() {
    return queue.isEmpty();
  }
}
//leetcode submit region end(Prohibit modification and deletion)
