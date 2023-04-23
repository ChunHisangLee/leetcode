1259
        Handshakes That Don't Cross
        2023-02-22 12:03:16

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfWays(int numPeople) {
        long mod = (long) 1e9 + 7;
        long[] dp = new long[numPeople / 2 + 1];
        dp[0] = 1;
        for (int i = 1; i <= numPeople / 2; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (dp[i] + dp[j] * dp[i - 1 - j]) % mod;
            }
        }
        return (int) dp[numPeople / 2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int numberOfWays(int numPeople) {
        long[] arr = new long[numPeople / 2 + 2];
        arr[1] = 1;
        long mod = (long) 1e9 + 7;
        long res = 1;
        for (int i = 2; i < numPeople / 2 + 2; ++i) {
            arr[i] = mod - mod / i * arr[(int) mod % i] % mod;
        }
        for (int i = 1; i <= numPeople / 2; ++i) {
            res = res * (i + numPeople / 2) % mod;
            res = res * arr[i] % mod;
        }
        return (int) (res * arr[numPeople / 2 + 1] % mod);
    }
}
 */