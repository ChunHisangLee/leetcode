
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSum(int[] nums) {
        final int OFFSET = 100;
        boolean[] seen = new boolean[201];

        int positiveSum = 0;
        boolean hasZero = false;
        int maxNegative = Integer.MIN_VALUE;

        for (int x : nums) {
            int idx = x + OFFSET;
            if (seen[idx]) {
                continue;
            }
            seen[idx] = true;

            if (x > 0) {
                positiveSum += x;
            } else if (x == 0) {
                hasZero = true;
            } else {
                if (x > maxNegative) {
                    maxNegative = x;
                }
            }
        }

        if (positiveSum > 0) {
            return positiveSum;
        }
        if (hasZero) {
            return 0;
        }
        return maxNegative;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
