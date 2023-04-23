1011
        Capacity To Ship Packages Within D Days
        2023-02-22 09:35:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        for (int weight : weights) {
            left = Math.max(left, weight);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 1;
            int carry = 0;
            for (int weight : weights) {
                carry += weight;
                if (carry > mid) {
                    count++;
                    carry = weight;
                }
            }
            if (count > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
