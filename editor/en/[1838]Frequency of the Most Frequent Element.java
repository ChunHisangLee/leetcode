class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        long sum = 0;
        int diff = 0;
        int res = 1;
        for (int i = 1; i < len; i++) {
            sum += (long) (nums[i] - nums[i - 1]) * (i - diff);
            while (sum > k) {
                sum -= nums[i] - nums[diff];
                diff++;
            }
            res = Math.max(res, i - diff + 1);
        }
        return res;
    }
}