//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (Math.abs(temp - target) < Math.abs(res - target))
                    res = temp;
                if (temp < target)
                    left++;
                else if (temp > target)
                    right--;
                else
                    return res;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
