
//leetcode submit region begin(Prohibit modification and deletion)
class SeatManager {
    PriorityQueue<Integer> pq;
    int index;

    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        index = 1;
    }

    public int reserve() {
        if (!pq.isEmpty()) {
            return pq.poll();
        }

        return index++;
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
//leetcode submit region end(Prohibit modification and deletion)
