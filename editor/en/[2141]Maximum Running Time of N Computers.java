
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxRunTime(int n, int[] batteries) {
        int bLen = batteries.length;
        if (bLen < n) {
            return 0;
        }
        long left = 0;
        long right = 0;
        for (int battery : batteries) {
            right += battery;
        }
        right /= n;
        while (left <= right) {
            long mid = (left + right) >> 1;
            if (isCheck(n, batteries, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    private boolean isCheck(int n, int[] batteries, long target) {
        long sum = target * n;
        for (int battery : batteries) {
            sum -= Math.min(target, battery);
        }
        return sum <= 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
