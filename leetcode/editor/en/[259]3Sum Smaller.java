/**
 * <p>Given an array of <code>n</code> integers <code>nums</code> and an integer&nbsp;<code>target</code>, find the number of index triplets <code>i</code>, <code>j</code>, <code>k</code> with <code>0 &lt;= i &lt; j &lt; k &lt; n</code> that satisfy the condition <code>nums[i] + nums[j] + nums[k] &lt; target</code>.</p>
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [-2,0,1,3], target = 2
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> Because there are two triplets which sums are less than 2:
 * [-2,0,1]
 * [-2,0,3]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [], target = 0
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [0], target = 0
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>n == nums.length</code></li>
 * <li><code>0 &lt;= n &lt;= 3500</code></li>
 * <li><code>-100 &lt;= nums[i] &lt;= 100</code></li>
 * <li><code>-100 &lt;= target &lt;= 100</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Two Pointers</li><li>Binary Search</li><li>Sorting</li></div></div><br><div><li>👍 1431</li><li>👎 138</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 2 && nums[i] * 3 < target; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
