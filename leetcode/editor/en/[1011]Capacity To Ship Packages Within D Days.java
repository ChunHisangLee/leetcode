1011
        Capacity To Ship Packages Within D Days
        2023-02-22 09:35:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int num : weights) {
            left = Math.max(num, left);
            right += num;
        }
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (isCheck(weights, mid, days)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean isCheck(int[] weights, int mid, int days) {
        int count = 1;
        int carry = 0;
        for (int num : weights) {
            carry += num;
            if (carry > mid) {
                count++;
                if (count > days) {
                    return true;
                }
                carry = num;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
