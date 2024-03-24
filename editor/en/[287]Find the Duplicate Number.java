//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] isDupicated = new boolean[nums.length];

        for (int num : nums) {
            if (isDupicated[num]) {
                return num;
            }

            isDupicated[num] = true;
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
