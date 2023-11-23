
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long sum = 0;

        for (int num : nums) {
            if (num == 0) {
                count++;
            } else {
                sum += countZeros(count);
                count = 0;
            }
        }
        return sum += countZeros(count);
    }

    private long countZeros(long n) {
        return n * (n + 1) / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
