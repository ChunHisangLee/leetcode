480
        Sliding Window Median
        2022-12-09 11:40:36

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] median = new double[n - k + 1];
        PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> b.compareTo(a)), large = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                if (!small.remove(nums[i - k])) {
                    large.remove(nums[i - k]);
                }
            }
            addNum(nums[i], small, large);
            if (i >= k - 1)
                median[i - k + 1] = findMedian(small, large);
        }
        return median;
    }

    private void addNum(int num, Queue<Integer> small, Queue<Integer> large) {
        if (small.size() > large.size()) {
            small.add(num);
            large.add(small.poll());
        } else {
            large.add(num);
            small.add(large.poll());
        }
    }

    private double findMedian(Queue<Integer> small, Queue<Integer> large) {
        if (small.size() > large.size()) {
            return small.peek();
        } else {
            return ((long) small.peek() + large.peek()) / 2.0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
