719
        Find K-th Smallest Pair Distance
        2022-12-30 16:11:44

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];
        for (int cnt = 0; left < right; cnt = 0) {
            int mid = left + (right - left) / 2;
            for (int i = 0, j = 0; i < n; i++) {
                while (j < n && nums[j] <= nums[i] + mid) j++;
                cnt += j - i - 1;
            }
            if (cnt < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
