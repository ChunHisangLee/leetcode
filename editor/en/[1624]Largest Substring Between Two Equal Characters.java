/**
 * Given a string s, return the length of the longest substring between two equal
 * characters, excluding the two characters. If there is no such substring return -1
 * .
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "aa"
 * Output: 0
 * Explanation: The optimal substring here is an empty substring between the two
 * 'a's.
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "abca"
 * Output: 2
 * Explanation: The optimal substring here is "bc".
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "cbzxy"
 * Output: -1
 * Explanation: There are no characters that appear twice in s.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 300
 * s contains only lowercase English letters.
 * <p>
 * <p>
 * Related Topics Hash Table String 👍 645 👎 38
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (arr[index] == -1) {
                arr[index] = i;
            } else {
                max = Math.max(max, i - arr[index] - 1);
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
