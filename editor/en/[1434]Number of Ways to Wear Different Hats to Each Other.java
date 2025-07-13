// Java
class Solution {
    static final int MOD = 1_000_000_007;

    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        List<Integer>[] hatToPeople = new ArrayList[41];
        for (int i = 1; i <= 40; i++) hatToPeople[i] = new ArrayList<>();
        for (int person = 0; person < n; person++) {
            for (int hat : hats.get(person)) {
                hatToPeople[hat].add(person);
            }
        }

        int[][] dp = new int[41][1 << n];
        dp[0][0] = 1;

        for (int hat = 1; hat <= 40; hat++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                dp[hat][mask] = dp[hat - 1][mask];
                    
                for (int person : hatToPeople[hat]) {
                    if ((mask & (1 << person)) != 0) {
                        dp[hat][mask] = (dp[hat][mask] + dp[hat - 1][mask ^ (1 << person)]) % MOD;
                    }
                }
            }
        }
        return dp[40][(1 << n) - 1];
    }
}
