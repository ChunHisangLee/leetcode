
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int arrangeCoins(int n) {
        long left = 0;
        long right = n;
        while (left <= right) {
            long mid = (left + right) >> 1;
            if ((mid) * (mid + 1) / 2 == n) {
                return (int) mid;
            } else if ((mid) * (mid + 1) / 2 < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) left - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
