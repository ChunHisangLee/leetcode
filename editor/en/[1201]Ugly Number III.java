//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long left = 1;
        long right = 2_000_000_000;
        long lcmAb = lcm(a, b);
        long lcmAc = lcm(a, c);
        long lcmBc = lcm(b, c);
        long lcmAbc = lcm(lcmAb, c);
        while (left < right) {
            long mid = left + (right - left) / 2;
            int count = (int) (mid / a + mid / b + mid / c - mid / lcmAb - mid / lcmAc - mid / lcmBc + mid / lcmAbc);
            if (count < n)
                left = mid + 1;
            else
                right = mid;
        }
        return (int) left;
    }

    private long gcd(long a, long b) {
        if (a > b)
            return gcd(b, a);
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
