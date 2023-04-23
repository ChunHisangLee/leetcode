/**
 * <p>We define a harmonious array as an array where the difference between its maximum value and its minimum value is <b>exactly</b> <code>1</code>.</p>
 *
 * <p>Given an integer array <code>nums</code>, return <em>the length of its longest harmonious subsequence among all its possible subsequences</em>.</p>
 *
 * <p>A <strong>subsequence</strong> of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,3,2,2,5,2,3,7]
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> The longest harmonious subsequence is [3,2,2,2,3].
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,2,3,4]
 * <strong>Output:</strong> 2
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,1,1,1]
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Hash Table</li><li>Sorting</li></div></div><br><div><li>👍 1900</li><li>👎 180</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                max = Math.max(max, map.get(key) + map.get(key + 1));
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
