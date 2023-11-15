346
        Moving Average from Data Stream
        2022-12-19 02:04:52

//leetcode submit region begin(Prohibit modification and deletion)
class MovingAverage {
    Deque<Integer> deque = new ArrayDeque<>();
    int size = 0;
    int sum = 0;


    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        deque.offer(val);
        sum += val;

        if (deque.size() > size) {
            int temp = deque.poll();
            sum -= temp;
        }

        return (double) sum / Math.min(size, deque.size());
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
//leetcode submit region end(Prohibit modification and deletion)
