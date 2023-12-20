
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] interval = new int[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = i + ranges[i];
            interval[left] = Math.max(interval[left], right);
        }

        int currEnd = 0;
        int nextEnd = 0;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            if (i > nextEnd) {
                return -1;
            }
            if (i > currEnd) {
                res++;
                currEnd = nextEnd;
            }
            nextEnd = Math.max(interval[i], nextEnd);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
