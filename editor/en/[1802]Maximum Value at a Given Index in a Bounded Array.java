// 1802
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int left = 0;
        int right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (helper(n, index, mid) <= maxSum)
                left = mid;
            else
                right = mid - 1;
        }
        return left + 1;
    }

    private long helper(int n, int index, int a) {
        int b = Math.max(a - index, 0);
        long res = (long) (a + b) * (a - b + 1) / 2;
        b = Math.max(a-((n - 1) - index), 0);
        res += (long) (a + b) * (a - b + 1) / 2;
        return res - a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
