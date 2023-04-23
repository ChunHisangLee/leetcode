/**
 * <p>Given a string <code>s</code>, partition the string into one or more <strong>substrings</strong> such that the characters in each substring are <strong>unique</strong>. That is, no letter appears in a single substring more than <strong>once</strong>.</p>
 *
 * <p>Return <em>the <strong>minimum</strong> number of substrings in such a partition.</em></p>
 *
 * <p>Note that each character should belong to exactly one substring in a partition.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "abacaba"
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong>
 * Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
 * It can be shown that 4 is the minimum number of substrings needed.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "ssssss"
 * <strong>Output:</strong> 6
 * <strong>Explanation:
 * </strong>The only valid partition is ("s","s","s","s","s","s").
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>s</code> consists of only English lowercase letters.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Hash Table</li><li>String</li><li>Greedy</li></div></div><br><div><li>👍 570</li><li>👎 28</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int partitionString(String s) {
        char[] ch = s.toCharArray();
        int[] arr = new int[26];
        int count = 1;
        for (char c : ch) {
            if (arr[c - 'a'] > 0) {
                count++;
                Arrays.fill(arr, 0);
            }
            arr[c - 'a']++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int partitionString(String s) {
        char[] c = s.toCharArray();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        int count = 1;
        int index = 0;
        for (int i = 0; i < c.length; i++) {
            if (arr[c[i] - 'a'] >= index) {
                count++;
                index = i;
            }
            arr[c[i] - 'a'] = i;
        }
        return count;
    }
}

class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        char[] ch = s.toCharArray();
        int count = 1;
        for (char c : ch) {
            if (set.contains(c)) {
                count++;
                set.clear();
            }
            set.add(c);
        }
        return count;
    }
}
 */