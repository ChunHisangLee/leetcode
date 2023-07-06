
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int curr = Integer.MIN_VALUE;
        int res = 0;
        for (int[] pair : pairs) {
            if (curr < pair[0]) {
                res++;
                curr = pair[1];
            }
        }
        return res;
    }
}

/*
- 10ms
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int curr = Integer.MIN_VALUE;
        int res = 0;
        for (int[] pair : pairs) {
            if (pair[0] > curr) {
                res++;
                curr = pair[1];
            }
        }
        return res;
    }
}

- 35ms
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
 */
//leetcode submit region end(Prohibit modification and deletion)
