class Solution {
    static final int MOD = 1_000_000_007;
    long[] fact, invFact;

    public int countGoodArrays(int n, int m, int k) {
        precomputeFactorials(n);
        long comb = nCr(n - 1, k);
        long pow = modPow(m - 1, n - 1 - k, MOD);
        long ans = comb * m % MOD;
        ans = ans * pow % MOD;
        return (int) ans;
    }

    void precomputeFactorials(int n) {
        int max = n;
        fact = new long[max + 1];
        invFact = new long[max + 1];
        fact[0] = 1;
        for (int i = 1; i <= max; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[max] = modPow(fact[max], MOD - 2, MOD);
        for (int i = max; i > 0; i--) invFact[i - 1] = invFact[i] * i % MOD;
    }

    long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }
    long modPow(long a, long b, int mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
