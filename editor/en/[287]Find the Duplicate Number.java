//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] isDuplicated = new boolean[nums.length];

        for (int num : nums) {
            if (isDuplicated[num]) {
                return num;
            }

            isDuplicated[num] = true;
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
