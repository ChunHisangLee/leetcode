/**
 * <p>Given a string <code>s</code>, find <em>the longest palindromic <strong>subsequence</strong>'s length in</em> <code>s</code>.</p>
 *
 * <p>A <strong>subsequence</strong> is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "bbbab"
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> One possible longest palindromic subsequence is "bbbb".
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "cbbd"
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> One possible longest palindromic subsequence is "bb".
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 1000</code></li>
 * <li><code>s</code> consists only of lowercase English letters.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>String</li><li>Dynamic Programming</li></div></div><br><div><li>👍 7164</li><li>👎 276</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] dp = new int[n];
        int[] dpPrev = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (c[i] == c[j]) {
                    dp[j] = dpPrev[j - 1] + 2;
                } else {
                    dp[j] = Math.max(dpPrev[j], dp[j - 1]);
                }
            }
            dpPrev = dp.clone();
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];
        return dyP(c, 0, n - 1, dp);
    }

    public int dyP(char[] c, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (c[i] == c[j]) {
            dp[i][j] = dyP(c, i + 1, j - 1, dp) + 2;
        } else {
            dp[i][j] = Math.max(dyP(c, i + 1, j, dp), dyP(c, i, j - 1, dp));
        }
        return dp[i][j];
    }
}

class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (c[i] == c[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

 */