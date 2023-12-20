/**
 * <p>Given a string <code>columnTitle</code> that represents the column title as appears in an Excel sheet, return <em>its corresponding column number</em>.</p>
 *
 * <p>For example:</p>
 *
 * <pre>
 * A -&gt; 1
 * B -&gt; 2
 * C -&gt; 3
 * ...
 * Z -&gt; 26
 * AA -&gt; 27
 * AB -&gt; 28
 * ...
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> columnTitle = "A"
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> columnTitle = "AB"
 * <strong>Output:</strong> 28
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> columnTitle = "ZY"
 * <strong>Output:</strong> 701
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= columnTitle.length &lt;= 7</code></li>
 * <li><code>columnTitle</code> consists only of uppercase English letters.</li>
 * <li><code>columnTitle</code> is in the range <code>["A", "FXSHRXW"]</code>.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Math</li><li>String</li></div></div><br><div><li>👍 4130</li><li>👎 327</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (char c : columnTitle.toCharArray()) {
            int num = c - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
