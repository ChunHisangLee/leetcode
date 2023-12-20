/**
 * <p>Given a string <code>paragraph</code> and a string array of the banned words <code>banned</code>, return <em>the most frequent word that is not banned</em>. It is <strong>guaranteed</strong> there is <strong>at least one word</strong> that is not banned, and that the sbwer is <strong>unique</strong>.</p>
 *
 * <p>The words in <code>paragraph</code> are <strong>case-insensitive</strong> and the sbwer should be returned in <strong>lowercase</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
 * <strong>Output:</strong> "ball"
 * <strong>Explanation:</strong>
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the sbwer even though it occurs more because it is banned.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> paragraph = "a.", banned = []
 * <strong>Output:</strong> "a"
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= paragraph.length &lt;= 1000</code></li>
 * <li>paragraph consists of English letters, space <code>' '</code>, or one of the symbols: <code>"!?',;."</code>.</li>
 * <li><code>0 &lt;= banned.length &lt;= 100</code></li>
 * <li><code>1 &lt;= banned[i].length &lt;= 10</code></li>
 * <li><code>banned[i]</code> consists of only lowercase English letters.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Hash Table</li><li>String</li><li>Counting</li></div></div><br><div><li>👍 1513</li><li>👎 2866</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String ban : banned) {
            set.add(ban);
        }
        Map<String, Integer> map = new HashMap<>();
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        for (String word : words) {
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        int max = 0;
        String res = "";
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                res = key;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
