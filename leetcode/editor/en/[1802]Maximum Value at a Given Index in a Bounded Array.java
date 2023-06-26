
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1;
        int right = maxSum - n;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (getSum(n, index, maxSum - n, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean getSum(int n, int index, int maxSum, int val) {
        int leftVal = Math.max(val - index, 0);
        int rightVal = Math.max(val - ((n - 1) - index), 0);
        long sumBefore = (long) (val + leftVal) * (val - leftVal + 1) / 2;
        long sumAfter = (long) (val + rightVal) * (val - rightVal + 1) / 2;
        return sumBefore + sumAfter - val <= maxSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
