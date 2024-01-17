//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums, int k) {
        int xorSum = 0;

        for (int num : nums) {
            xorSum ^= num;
        }

        int difBits = xorSum ^ k;
        return Integer.bitCount(difBits);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
