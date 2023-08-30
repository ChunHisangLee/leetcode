
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minimumPossibleSum(int n, int target) {
        long k = target / 2;
        if (n <= k) {
            return 1L * n * (n + 1) / 2;
        }
        return k * (k + 1) / 2 + (target + target + n - k - 1) * (n - k) / 2;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public long minimumPossibleSum(int n, int target) {
        long sum = 0;
        Set<Long> set = new HashSet<>();
        for (long i = 1; set.size() < n; i++) {
            if (!set.contains(target - i)) {
                set.add(i);
                sum += i;
            }
        }
        return sum;
    }
}
 */