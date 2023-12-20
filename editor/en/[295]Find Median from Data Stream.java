295
        Find Median from Data Stream
        2022-12-09 10:57:35

//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    PriorityQueue<Integer> pqMax;
    PriorityQueue<Integer> pqMin;

    public MedianFinder() {
        pqMax = new PriorityQueue<>();
        pqMin = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        pqMin.add(num);
        pqMax.add(pqMin.poll());
        if (pqMax.size() > pqMin.size()) {
            pqMin.add(pqMax.poll());
        }
    }

    public double findMedian() {
        if (pqMin.size() > pqMax.size()) {
            return pqMin.peek();
        } else {
            return (pqMin.peek() + pqMax.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
