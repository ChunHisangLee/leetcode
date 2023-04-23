/**
 * <p>Given three integer arrays <code>arr1</code>, <code>arr2</code> and <code>arr3</code>&nbsp;<strong>sorted</strong> in <strong>strictly increasing</strong> order, return a sorted array of <strong>only</strong>&nbsp;the&nbsp;integers that appeared in <strong>all</strong> three arrays.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * <strong>Output:</strong> [1,5]
 * <strong>Explanation: </strong>Only 1 and 5 appeared in the three arrays.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> arr1 = [197,418,523,876,1356], arr2 = [501,880,1593,1710,1870], arr3 = [521,682,1337,1395,1764]
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= arr1.length, arr2.length, arr3.length &lt;= 1000</code></li>
 * <li><code>1 &lt;= arr1[i], arr2[i], arr3[i] &lt;= 2000</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Hash Table</li><li>Binary Search</li><li>Counting</li></div></div><br><div><li>👍 535</li><li>👎 24</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : arr2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : arr3) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 3) {
                list.add(key);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
