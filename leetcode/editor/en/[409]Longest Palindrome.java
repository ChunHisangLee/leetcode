/**
 * <p>Given a string <code>s</code> which consists of lowercase or uppercase letters, return <em>the length of the <strong>longest palindrome</strong></em>&nbsp;that can be built with those letters.</p>
 *
 * <p>Letters are <strong>case sensitive</strong>, for example,&nbsp;<code>"Aa"</code> is not considered a palindrome here.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "abccccdd"
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong> One longest palindrome that can be built is "dccaccd", whose length is 7.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "a"
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The longest palindrome that can be built is "a", whose length is 1.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 2000</code></li>
 * <li><code>s</code> consists of lowercase <strong>and/or</strong> uppercase English&nbsp;letters only.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Hash Table</li><li>String</li><li>Greedy</li></div></div><br><div><li>👍 4589</li><li>👎 282</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        int count = 0;
        for (int num : arr) {
            count += num / 2 * 2;
            if (count % 2 == 0 && num % 2 == 1) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
