// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int totalTank = 0;
    int currTank = 0;
    int startStation = 0;

    for (int i = 0; i < n; i++) {
      int net = gas[i] - cost[i];
      totalTank += net;
      currTank += net;

      if (currTank < 0) {
        startStation = i + 1;
        currTank = 0;
      }
    }

    return (totalTank >= 0) ? startStation : -1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
