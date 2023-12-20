502
        IPO
        2022-12-10 21:18:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pqCan = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        PriorityQueue<int[]> pqCannot = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < profits.length; i++) {
            if (w >= capital[i]) {
                pqCan.add(new int[]{capital[i], profits[i]});
            } else {
                pqCannot.add(new int[]{capital[i], profits[i]});
            }
        }
        for (int i = 0; i < k; i++) {
            if (pqCan.isEmpty()) {
                break;
            }
            w += pqCan.poll()[1];
            while (!pqCannot.isEmpty() && pqCannot.peek()[0] <= w) {
                pqCan.add(pqCannot.poll());
            }
        }
        return w;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
