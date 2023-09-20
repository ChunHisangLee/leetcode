
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums, int x) {
        int total = Arrays.stream(nums).sum();
        int n = nums.length;
        int target = total - x;
        int max = -1;
        int left = 0;
        int current = 0;

        for (int right = 0; right < n; right++) {
            current += nums[right];

            while ((current > target) && left <= right) {
                current -= nums[left];
                left++;
            }

            if (current == target) {
                max = Math.max(max, right - left + 1);
            }
        }

        return max == -1 ? -1 : n - max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
