// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  private static final int MOD = 1_000_000_007;

  public int idealArrays(int n, int maxValue) {
    int kMax = 0 ;
    int v = 1;
    while (v <= maxValue) {
      kMax++;
      v <<= 1;
    }
    List<Integer>[] divisors = new List[maxValue + 1];
    for (int i = 1; i <= maxValue; i++) {
      divisors[i] = new ArrayList<>();
    }
    for (int d = 1; d <= maxValue; d++) {
      for (int m = d; m <= maxValue; m += d) {
        divisors[m].add(d);
      }
    }
    long[] inv = new long[kMax + 1];
    inv[1] = 1;
    for (int i = 2; i <= kMax; i++) {
      inv[i] = MOD - (MOD / i) * inv[MOD % i] % MOD;
    }
    int[] dpPrev = new int[maxValue + 1];
    Arrays.fill(dpPrev, 1);
    long ans = (long) maxValue; // k=1 ⇒ C(n-1,0)=1 * g₁=maxValue
    long comb = 1; // comb = C(n-1,0)
    int[] dpCurr = new int[maxValue + 1];
    for (int k = 2; k <= kMax; k++) {
      for (int x = 1; x <= maxValue; x++) {
        long sum = 0;
        for (int d : divisors[x]) {
          if (d < x) {
            sum += dpPrev[d];
            if (sum >= MOD) sum -= MOD;
          }
        }
        dpCurr[x] = (int) sum;
      }
      long gk = 0;
      for (int x = 1; x <= maxValue; x++) {
        gk += dpCurr[x];
        if (gk >= MOD) gk -= MOD;
      }
      comb = comb * (n - k + 1) % MOD * inv[k - 1] % MOD;
      ans = (ans + comb * gk) % MOD;
      System.arraycopy(dpCurr, 1, dpPrev, 1, maxValue);
    }
    return (int) ans;
  }
}

// leetcode submit region end(Prohibit modification and deletion)
