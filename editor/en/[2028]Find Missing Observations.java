//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean * (m + n);
        int observedSum = 0;

        for (int roll : rolls) {
            observedSum += roll;
        }

        int missingSum = totalSum - observedSum;

        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }

        int[] result = new int[n];
        int baseValue = missingSum / n;
        int remainder = missingSum % n;

        for (int i = 0; i < n; i++) {
            result[i] = baseValue + (i < remainder ? 1 : 0);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
