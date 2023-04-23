/**
 * <p>Given an array of strings <code>wordsDict</code> and two different strings that already exist in the array <code>word1</code> and <code>word2</code>, return <em>the shortest distance between these two words in the list</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 * <strong>Output:</strong> 3
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= wordsDict.length &lt;= 3 * 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= wordsDict[i].length &lt;= 10</code></li>
 * <li><code>wordsDict[i]</code> consists of lowercase English letters.</li>
 * <li><code>word1</code> and <code>word2</code> are in <code>wordsDict</code>.</li>
 * <li><code>word1 != word2</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>String</li></div></div><br><div><li>👍 1199</li><li>👎 103</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                if (index != -1 && !wordsDict[index].equals(wordsDict[i])) {
                    min = Math.min(min, i - index);
                }
                index = i;
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
