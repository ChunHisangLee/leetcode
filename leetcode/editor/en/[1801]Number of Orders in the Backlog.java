
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        final int MOD = (int) 1e9 + 7;
        PriorityQueue<int[]> pqBuy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> pqSell = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] order : orders) {
            if (order[2] == 0) {
                pqBuy.add(order);
            } else {
                pqSell.add(order);
            }
            while (!pqBuy.isEmpty() && !pqSell.isEmpty() && pqBuy.peek()[0] >= pqSell.peek()[0]) {
                int min = Math.min(pqBuy.peek()[1], pqSell.peek()[1]);
                pqBuy.peek()[1] -= min;
                pqSell.peek()[1] -= min;
                if (pqBuy.peek()[1] == 0) {
                    pqBuy.poll();
                }
                if (pqSell.peek()[1] == 0) {
                    pqSell.poll();
                }
            }
        }
        int res = 0;
        for (int[] arr : pqBuy) {
            res = (res + arr[1]) % MOD;
        }
        for (int[] arr : pqSell) {
            res = (res + arr[1]) % MOD;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
