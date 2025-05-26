// leetcode submit region begin(Prohibit modification and deletion)
/** Queue implementation using two stacks with lazy transfer. All operations are amortized O(1). */
public class MyQueue {
  private final Stack<Integer> inbox;
  private final Stack<Integer> outbox;

  /** Initialize your data structure here. */
  public MyQueue() {
    inbox = new Stack<>();
    outbox = new Stack<>();
  }

  /**
   * Pushes element x to the back of the queue.
   *
   * @param x the element to push
   */
  public void push(int x) {
    inbox.push(x);
  }

  /**
   * Removes the element from the front of the queue and returns it. Transfers elements only if
   * outbox is empty.
   *
   * @return the front element
   */
  public int pop() {
    moveIfNeeded();
    return outbox.pop();
  }

  /**
   * Gets the front element.
   *
   * @return the front element without removing it
   */
  public int peek() {
    moveIfNeeded();
    return outbox.peek();
  }

  /**
   * Returns whether the queue is empty.
   *
   * @return true if empty, false otherwise
   */
  public boolean empty() {
    return inbox.isEmpty() && outbox.isEmpty();
  }

  /** Helper to transfer only when outbox is empty */
  private void moveIfNeeded() {
    if (outbox.isEmpty()) {
      while (!inbox.isEmpty()) {
        outbox.push(inbox.pop());
      }
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
