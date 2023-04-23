45
        Jump Game II
        2022-12-26 09:46:18

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int count = 0;
        int currFar = 0;
        int currEnd = 0;
        for (int i = 0; i < n; i++) {
            currFar = Math.max(currFar, i + nums[i]);
            if (i == currEnd) {
                count++;
                currEnd = currFar;
            }
        }
        return count - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
