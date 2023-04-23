/**
 * <p>Given an integer <code>columnNumber</code>, return <em>its corresponding column title as it appears in an Excel sheet</em>.</p>
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
 * <strong>Input:</strong> columnNumber = 1
 * <strong>Output:</strong> "A"
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> columnNumber = 28
 * <strong>Output:</strong> "AB"
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> columnNumber = 701
 * <strong>Output:</strong> "ZY"
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= columnNumber &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Math</li><li>String</li></div></div><br><div><li>👍 3694</li><li>👎 535</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            char c = (char) (columnNumber % 26 + 'A');
            sb.append(c);
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
