
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minimumReplacement(int[] nums) {
        long res = 0;
        int n = nums.length;
        int prev = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int element = nums[i] / prev;
            if (nums[i] % prev != 0) {
                element++;
                prev = nums[i] / element;
            }
            res += element - 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
