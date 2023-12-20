/**
 * <p>Given strings <code>s1</code> and <code>s2</code>, return <em>the minimum contiguous&nbsp;substring part of </em><code>s1</code><em>, so that </em><code>s2</code><em> is a subsequence of the part</em>.</p>
 *
 * <p>If there is no such window in <code>s1</code> that covers all characters in <code>s2</code>, return the empty string <code>""</code>. If there are multiple such minimum-length windows, return the one with the <strong>left-most starting index</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s1 = "abcdebdde", s2 = "bde"
 * <strong>Output:</strong> "bcde"
 * <strong>Explanation:</strong>
 * "bcde" is the answer because it occurs before "bdde" which has the same length.
 * "deb" is not a smaller window because the elements of s2 in the window must occur in order.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s1 = "jmeqksfrsdcmsiwvaovztaqenprpvnbstl", s2 = "u"
 * <strong>Output:</strong> ""
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s1.length &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= s2.length &lt;= 100</code></li>
 * <li><code>s1</code> and <code>s2</code> consist of lowercase English letters.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>String</li><li>Dynamic Programming</li><li>Sliding Window</li></div></div><br><div><li>👍 1351</li><li>👎 81</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s1, String s2) {
        int i = -1;
        String res = "";
        while (true) {
            for (char c : s2.toCharArray()) {
                i = s1.indexOf(c, i + 1);
                if (i == -1) {
                    return res;
                }
            }
            i++;
            int index = i;
            for (int j = s2.length() - 1; j >= 0; j--) {
                i = s1.lastIndexOf(s2.charAt(j), i - 1);
            }
            if (res == "" || res.length() > index - i) {
                res = s1.substring(i, index);
                i++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
