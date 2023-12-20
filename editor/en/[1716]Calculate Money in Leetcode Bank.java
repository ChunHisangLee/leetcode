
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        int count = 0;

        while (n >= 7) {
            sum += (28 + count * 7);
            count++;
            n -= 7;
        }

        for (int i = 0; i < n; i++) {
            sum += (count + i + 1);
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int remainingDays = n % 7;
        int totalForWeeks = weeks * (2 * 28 + (weeks - 1) * 7) / 2;
        int totalForDays = remainingDays * (2 * (weeks + 1) + (remainingDays - 1)) / 2;
        return totalForWeeks + totalForDays;
    }
}
 */