/**
 * <p>Given an integer <code>n</code>, return all the <strong>strobogrammatic numbers</strong> that are of length <code>n</code>. You may return the answer in <strong>any order</strong>.</p>
 *
 * <p>A <strong>strobogrammatic number</strong> is a number that looks the same when rotated <code>180</code> degrees (looked at upside down).</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> n = 2
 * <strong>Output:</strong> ["11","69","88","96"]
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> n = 1
 * <strong>Output:</strong> ["0","1","8"]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 14</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>String</li><li>Recursion</li></div></div><br><div><li>👍 852</li><li>👎 222</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    public List<String> findStrobogrammatic(int n) {
        Deque<String> dq = new ArrayDeque<>();
        int currLen;
        if (n % 2 == 0) {
            currLen = 0;
            dq.add("");
        } else {
            currLen = 1;
            dq.add("0");
            dq.add("1");
            dq.add("8");
        }
        while (currLen < n) {
            currLen += 2;
            for (int i = dq.size(); i > 0; --i) {
                String number = dq.poll();
                for (char[] pair : pairs) {
                    if (currLen != n || pair[0] != '0') {
                        dq.add(pair[0] + number + pair[1]);
                    }
                }
            }
        }
        List<String> list = new ArrayList<>();
        while (!dq.isEmpty()) {
            list.add(dq.poll());
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
