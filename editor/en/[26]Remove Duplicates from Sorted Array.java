

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[res - 1])
                nums[res++] = nums[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
