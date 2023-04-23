/**
 * <p>Given a string <code>s</code>. In one step you can insert any character at any index of the string.</p>
 *
 * <p>Return <em>the minimum number of steps</em> to make <code>s</code>&nbsp;palindrome.</p>
 *
 * <p>A&nbsp;<b>Palindrome String</b>&nbsp;is one that reads the same backward as well as forward.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "zzazz"
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> The string "zzazz" is already palindrome we do not need any insertions.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "mbadm"
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> String can be "mbdadbm" or "mdbabdm".
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "leetcode"
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> Inserting 5 characters the string becomes "leetcodocteel".
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 500</code></li>
 * <li><code>s</code> consists of lowercase English letters.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>String</li><li>Dynamic Programming</li></div></div><br><div><li>👍 3158</li><li>👎 36</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minInsertions(String s) {
        int lps = dyP(s);
        return s.length() - lps;
    }

    public int dyP(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int max = 0;
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
            max = 0;
            for (int i = j - 1; i >= 0; i--) {
                int len = dp[i];
                if (c[i] == c[j]) {
                    dp[i] = 2 + max;
                }
                max = Math.max(max, len);
            }
        }
        for (int len : dp) {
            max = Math.max(max, len);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
