
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int prev = -1;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                max = prev < 0 ? i : Math.max(max, (i - prev) / 2);
                prev = i;
            }
        }

        max = Math.max(max, n - 1 - prev);
        return max;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
