/**
 * <p>A subsequence of a string <code>s</code> is considered a <strong>good palindromic subsequence</strong> if:</p>
 *
 * <ul>
 * <li>It is a subsequence of <code>s</code>.</li>
 * <li>It is a palindrome (has the same value if reversed).</li>
 * <li>It has an <strong>even</strong> length.</li>
 * <li>No two consecutive characters are equal, except the two middle ones.</li>
 * </ul>
 *
 * <p>For example, if <code>s = "abcabcabb"</code>, then <code>"abba"</code> is considered a <strong>good palindromic subsequence</strong>, while <code>"bcb"</code> (not even length) and <code>"bbbb"</code> (has equal consecutive characters) are not.</p>
 *
 * <p>Given a string <code>s</code>, return <em>the <strong>length</strong> of the <strong>longest good palindromic subsequence</strong> in </em><code>s</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "bbabab"
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The longest good palindromic subsequence of s is "baab".
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "dcbccacdb"
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The longest good palindromic subsequence of s is "dccd".
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 250</code></li>
 * <li><code>s</code> consists of lowercase English letters.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>String</li><li>Dynamic Programming</li></div></div><br><div><li>👍 134</li><li>👎 28</li></div>
 */
/*
還不會
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (c[i] == c[j]) {
                    dp[j] = max + 2;
                    res = Math.max(res, dp[j]);
                } else {
                    max = Math.max(max, dp[j]);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (c[i] == c[j]) {
                    res = Math.max(res, dp[j] = max + 2);
                } else {
                    max = Math.max(max, dp[j]);
                }
            }
        }
        return res;
    }
}
 */