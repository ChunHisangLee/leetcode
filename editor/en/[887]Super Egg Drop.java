
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int superEggDrop(int k, int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (isCheck(k, n, mid) < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int isCheck(int k, int n, int mid) {
        int res = 0;
        int right = 1;
        for (int i = 1; i <= k; i++) {
            right = right * (mid - i + 1) / i;
            res += right;
            if (res >= n) {
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
