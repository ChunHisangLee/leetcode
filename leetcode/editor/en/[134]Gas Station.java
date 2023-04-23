134
        Gas Station
        2023-01-07 09:48:24

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int capacity = 0;
        int curr = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            capacity += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }
        return capacity >= 0 ? start : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
