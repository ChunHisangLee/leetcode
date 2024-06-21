
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int baseSatisfied = IntStream.range(0, n)
                .filter(i -> grumpy[i] == 0)
                .map(i -> customers[i])
                .sum();
        int additionalSatisfied = 0;
        int maxAdditionalSatisfied = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }

            if (i >= minutes && grumpy[i - minutes] == 1) {
                additionalSatisfied -= customers[i - minutes];
            }

            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, additionalSatisfied);
        }

        return baseSatisfied + maxAdditionalSatisfied;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
