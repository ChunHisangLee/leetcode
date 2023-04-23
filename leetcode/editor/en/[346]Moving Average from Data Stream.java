346
        Moving Average from Data Stream
        2022-12-19 02:04:52

//leetcode submit region begin(Prohibit modification and deletion)
class MovingAverage {
    int size;
    int count = 0;
    int sum = 0;
    Queue<Integer> queue = new LinkedList<>();

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        count++;
        queue.add(val);
        int tail = count > size ? queue.remove() : 0;
        sum = sum - tail + val;
        return (double) sum / Math.min(size, count);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
//leetcode submit region end(Prohibit modification and deletion)
