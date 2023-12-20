/**
 * <p>Given a string <code>num</code> which represents an integer, return <code>true</code> <em>if</em> <code>num</code> <em>is a <strong>strobogrammatic number</strong></em>.</p>
 *
 * <p>A <strong>strobogrammatic number</strong> is a number that looks the same when rotated <code>180</code> degrees (looked at upside down).</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = "69"
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = "88"
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = "962"
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= num.length &lt;= 50</code></li>
 * <li><code>num</code> consists of only digits.</li>
 * <li><code>num</code> does not contain any leading zeros except for zero itself.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Hash Table</li><li>Two Pointers</li><li>String</li></div></div><br><div><li>👍 542</li><li>👎 946</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStrobogrammatic(String num) {
        int[] arr = new int[]{0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        char[] c = num.toCharArray();
        for (int left = 0, right = c.length - 1; left <= right; left++, right--) {
            if (arr[c[left] - '0'] != c[right] - '0') {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
