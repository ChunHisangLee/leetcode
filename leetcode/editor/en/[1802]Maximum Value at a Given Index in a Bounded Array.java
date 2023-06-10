
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1;
        int right = maxSum;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (getSum(n, index, mid) <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public long getSum(int n, int index, int value) {
        long res = 0;
        if (value > index) {
            res += (long) (value + value - index) * (index + 1) / 2;
        } else {
            res += (long) (value + 1) * value / 2 + index - value + 1;
        }
        if (value >= n - index) {
            res += (long) (value + value - n + 1 + index) * (n - index) / 2;
        } else {
            res += (long) (value + 1) * value / 2 + n - index - value;
        }
        return res - value;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
