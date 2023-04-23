//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3)
            return nums.length;
        int res = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[res - 2])
                nums[res++] = nums[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
