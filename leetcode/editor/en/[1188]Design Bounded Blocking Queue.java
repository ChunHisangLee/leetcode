
//leetcode submit region begin(Prohibit modification and deletion)
class BoundedBlockingQueue {
    private Deque<Integer> deque;
    private int capacity;
    private ReentrantLock lock;
    private Condition notEmpty;
    private Condition notFull;

    public BoundedBlockingQueue(int capacity) {
        this.deque = new ArrayDeque<>();
        this.capacity = capacity;
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();

        try {
            while (deque.size() == capacity) {
                notFull.await();
            }

            deque.offer(element);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();

        try {
            while (deque.isEmpty()) {
                notEmpty.await();
            }

            int item = deque.poll();
            notFull.signal();
            return item;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();

        try {
            return deque.size();
        } finally {
            lock.unlock();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
