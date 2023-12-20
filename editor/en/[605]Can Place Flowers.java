/**
 * <p>You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in <strong>adjacent</strong> plots.</p>
 *
 * <p>Given an integer array <code>flowerbed</code> containing <code>0</code>'s and <code>1</code>'s, where <code>0</code> means empty and <code>1</code> means not empty, and an integer <code>n</code>, return <em>if</em> <code>n</code> new flowers can be planted in the <code>flowerbed</code> without violating the no-adjacent-flowers rule.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> flowerbed = [1,0,0,0,1], n = 1
 * <strong>Output:</strong> true
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> flowerbed = [1,0,0,0,1], n = 2
 * <strong>Output:</strong> false
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= flowerbed.length &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>flowerbed[i]</code> is <code>0</code> or <code>1</code>.</li>
 * <li>There are no two adjacent flowers in <code>flowerbed</code>.</li>
 * <li><code>0 &lt;= n &lt;= flowerbed.length</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Greedy</li></div></div><br><div><li>👍 3661</li><li>👎 734</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                boolean left = (i == 0) || (flowerbed[i - 1] == 0);
                boolean right = (i == len - 1) || (flowerbed[i + 1] == 0);
                if (left && right) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
