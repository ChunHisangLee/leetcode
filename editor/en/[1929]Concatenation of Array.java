

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] result = new int[n * 2];
        System.arraycopy(nums, 0, result, 0, n);
        System.arraycopy(nums, 0, result, n, n);

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
