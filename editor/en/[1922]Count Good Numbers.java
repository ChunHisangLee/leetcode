
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int MOD = 1000000007;

    // Fast modular exponentiation
    private long modPow(long base, long exponent) {
        long result = 1;
        base = base % MOD;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {  // if exponent is odd
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent >>= 1; // divide exponent by 2
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        // evenCount is the number of digits at even indices:
        long evenCount = (n + 1) / 2;  // accounts for 0-index; for odd n, one extra even index.
        // oddCount is the number of digits at odd indices:
        long oddCount = n / 2;

        // Total good strings = 5^evenCount * 4^oddCount (all modulo MOD)
        long evenPart = modPow(5, evenCount);
        long oddPart = modPow(4, oddCount);
        long result = (evenPart * oddPart) % MOD;

        return (int) result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
