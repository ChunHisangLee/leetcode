//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int answer = nums[0];
        for (int i = 1; i < nums.length; i++) {
            answer = answer ^ nums[i];
        }
        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
