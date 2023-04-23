787
        Cheapest Flights Within K Stops
        2023-01-26 10:18:23

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prev = new int[n];
        int[] curr = new int[n];
        Arrays.fill(prev, Integer.MAX_VALUE);
        Arrays.fill(curr, Integer.MAX_VALUE);
        prev[src] = 0;
        for (int i = 0; i <= k; i++) {
            curr[src] = 0;
            for (int[] flight : flights) {
                if (prev[flight[0]] < Integer.MAX_VALUE) {
                    curr[flight[1]] = Math.min(curr[flight[1]], prev[flight[0]] + flight[2]);
                }
            }
            prev = curr.clone();
        }
        return curr[dst] == Integer.MAX_VALUE ? -1 : curr[dst];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
