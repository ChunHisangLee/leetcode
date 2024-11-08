
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] answer = new int[n];
        int mask = (1 << maximumBit) - 1;
        int totalXor = 0;

        for (int num : nums) {
            totalXor ^= num;
        }

        for (int i = 0; i < n; i++) {
            int k = totalXor ^ mask;
            answer[i] = k;
            totalXor ^= nums[n - 1 - i];
        }

        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
