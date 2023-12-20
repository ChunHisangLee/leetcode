
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int m = 1;
        int result = n;

        Arrays.sort(nums);

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i];
            }
        }

        for (int i = 0, j = 0; i < m; i++) {
            while (j < m && nums[j] - nums[i] < n) {
                j++;
            }

            result = Math.min(result, n - (j - i));
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
