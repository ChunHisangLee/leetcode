
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (isCheck(nums, mid, threshold)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean isCheck(int[] nums, int mid, int threshold) {
        int count = 0;
        for (int num : nums) {
            count += (num + (mid - 1)) / mid;
            if (count > threshold) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
