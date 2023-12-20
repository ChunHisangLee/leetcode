/**
 * <p>You are given a nested list of integers <code>nestedList</code>. Each element is either an integer or a list whose elements may also be integers or other lists.</p>
 *
 * <p>The <strong>depth</strong> of an integer is the number of lists that it is inside of. For example, the nested list <code>[1,[2,2],[[3],2],1]</code> has each integer's value set to its <strong>depth</strong>.</p>
 *
 * <p>Return <em>the sum of each integer in </em><code>nestedList</code><em> multiplied by its <strong>depth</strong></em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/14/nestedlistweightsumex1.png" style="width: 405px; height: 99px;" />
 * <pre>
 * <strong>Input:</strong> nestedList = [[1,1],2,[1,1]]
 * <strong>Output:</strong> 10
 * <strong>Explanation:</strong> Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/14/nestedlistweightsumex2.png" style="width: 315px; height: 106px;" />
 * <pre>
 * <strong>Input:</strong> nestedList = [1,[4,[6]]]
 * <strong>Output:</strong> 27
 * <strong>Explanation:</strong> One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4*2 + 6*3 = 27.</pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nestedList = [0]
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nestedList.length &lt;= 50</code></li>
 * <li>The values of the integers in the nested list is in the range <code>[-100, 100]</code>.</li>
 * <li>The maximum <strong>depth</strong> of any integer is less than or equal to <code>50</code>.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Depth-First Search</li><li>Breadth-First Search</li></div></div><br><div><li>👍 1578</li><li>👎 361</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 * <p>
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 * <p>
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * public void add(NestedInteger ni);
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    public int dfs(List<NestedInteger> list, int level) {
        int sum = 0;
        for (NestedInteger item : list) {
            if (item.isInteger()) {
                sum += item.getInteger() * level;
            } else {
                sum += dfs(item.getList(), level + 1);
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Deque<NestedInteger> dq = new ArrayDeque<>();
        dq.addAll(nestedList);
        int level = 1;
        int sum = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                NestedInteger curr = dq.poll();
                if (curr.isInteger()) {
                    sum += curr.getInteger() * level;
                } else {
                    dq.addAll(curr.getList());
                }
            }
            level++;
        }
        return sum;
    }
}
 */