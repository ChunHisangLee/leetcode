69
        Sqrt(x)
        2022-12-28 17:29:33

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        long left = 1;
        long right = x;
        while (left <= right) {
            long mid = (left + right) >> 1;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) left - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
