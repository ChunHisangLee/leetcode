
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (getCheck(nums, mid, p) < p) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int getCheck(int[] nums, int mid, int p) {
        int k = 0;
        for (int i = 1; i < nums.length && k < p; i++) {
            if (nums[i] - nums[i - 1] <= mid) {
                k++;
                i++;
            }
        }
        return k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
