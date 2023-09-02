
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            String str = s.substring(i);
            dp[i] = dp[i + 1] + 1;
            for (int j = 0; j < dictionary.length; j++) {
                if (str.startsWith(dictionary[j])) {
                    dp[i] = Math.min(dp[i], dp[i + dictionary[j].length()]);
                }
            }
        }
        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Top -Down -42ms
class Solution {
    Integer[] memo;
    Set<String> set;

    public int minExtraChar(String s, String[] dictionary) {
        set = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        memo = new Integer[n];
        return dp(0, n, s);
    }

    private int dp(int start, int n, String s) {
        if (start == n) {
            return 0;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        int res = dp(start + 1, n, s) + 1;
        for (int end = start; end < n; end++) {
            String str = s.substring(start, end + 1);
            if (set.contains(str)) {
                res = Math.min(res, dp(end + 1, n, s));
            }
        }
        return memo[start] = res;
    }
}

Bottom - Up  -13ms
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            String str = s.substring(i);
            dp[i] = dp[i + 1] + 1;
            for (int j = 0; j < dictionary.length; j++) {
                if (str.startsWith(dictionary[j])) {
                    dp[i] = Math.min(dp[i], dp[i + dictionary[j].length()]);
                }
            }
        }
        return dp[0];
    }
}
 */