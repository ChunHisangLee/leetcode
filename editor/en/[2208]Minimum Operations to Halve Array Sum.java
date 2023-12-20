2208
        Minimum Operations to Halve Array Sum
        2022-12-09 10:02:01

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int halveArray(int[] nums) {
        double target = 0;
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (double num : nums) {
            target += num;
            heap.add(num);
        }
        target /= 2;
        int res = 0;
        while (target > 0) {
            res++;
            double x = heap.remove();
            target -= (x / 2);
            heap.add(x / 2);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
