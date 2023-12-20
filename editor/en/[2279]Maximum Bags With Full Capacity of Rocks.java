2279
        Maximum Bags With Full Capacity of Rocks
        2022-12-27 09:38:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        for (int i = 0; i < n; i++) {
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        int res = 0;
        while (res < n) {
            if (additionalRocks >= capacity[res]) {
                additionalRocks -= capacity[res];
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
