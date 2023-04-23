1099
        Two Sum Less Than K
        2022-11-28 10:53:42

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                ans = Math.max(ans, sum);
                left++;
            } else
                right--;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
