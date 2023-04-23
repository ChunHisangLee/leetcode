55
        Jump Game
        2022-12-26 08:56:33

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int last = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
