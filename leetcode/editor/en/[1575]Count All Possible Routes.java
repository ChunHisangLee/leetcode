
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final int MOD = (int) 1e9 + 7;
    int[][] dp;
    int[] locations;
    int n;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        this.locations = locations;
        n = locations.length;
        dp = new int[n][fuel + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return dyP(start, finish, fuel);
    }

    private int dyP(int curr, int finish, int fuel) {
        if (dp[curr][fuel] != -1) {
            return dp[curr][fuel];
        }
        if (fuel == 0 && curr != finish) {
            dp[curr][fuel] = 0;
            return 0;
        }
        if (fuel > 0 && Math.abs(locations[curr] - locations[finish]) > fuel) {
            dp[curr][fuel] = 0;
            return 0;
        }
        int count = curr == finish ? 1 : 0;
        for (int next = 0; next < n; next++) {
            if (next != curr) {
                int cost = Math.abs(locations[curr] - locations[next]);
                if (cost <= fuel) {
                    count = (count + dyP(next, finish, fuel - cost)) % MOD;
                }
            }
        }
        dp[curr][fuel] = count;
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    private final int MOD = (int) 1e9 + 7;
    int[][] dp;
    int[] locations;
    int n;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        this.locations = locations;
        n = locations.length;
        dp = new int[n][fuel + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return dyP(start, finish, fuel);
    }

    private int dyP(int curr, int finish, int fuel) {
        if (fuel < 0) {
            return 0;
        }
        if (dp[curr][fuel] != -1) {
            return dp[curr][fuel];
        }
        int count = curr == finish ? 1 : 0;
        for (int next = 0; next < n; next++) {
            if (next != curr) {
                int cost = Math.abs(locations[curr] - locations[next]);
                count = (count + dyP(next, finish, fuel - cost)) % MOD;
            }
        }
        dp[curr][fuel] = count;
        return count;
    }
}
 */