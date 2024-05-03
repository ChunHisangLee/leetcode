//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        int[] nums = caluculatePairs(nums1, nums2);
        Arrays.sort(nums);
        return countPositivePairs(nums);
    }

    private int[] caluculatePairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = nums1[i] - nums2[i];
        }

        return nums;
    }

    private long countPositivePairs(int[] nums) {
        int n = nums.length;
        long result = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (nums[left] + nums[right] > 0) {
                result += right - left;
                right--;
            } else {
                left++;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
