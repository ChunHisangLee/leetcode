/**
 * <p>The <strong>diameter</strong> of a tree is <strong>the number of edges</strong> in the longest path in that tree.</p>
 *
 * <p>There is an undirected tree of <code>n</code> nodes labeled from <code>0</code> to <code>n - 1</code>. You are given a 2D array <code>edges</code> where <code>edges.length == n - 1</code> and <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that there is an undirected edge between nodes <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code> in the tree.</p>
 *
 * <p>Return <em>the <strong>diameter</strong> of the tree</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/01/19/tree1.jpg" style="width: 224px; height: 145px;" />
 * <pre>
 * <strong>Input:</strong> edges = [[0,1],[0,2]]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The longest path of the tree is the path 1 - 0 - 2.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/01/19/tree2.jpg" style="width: 224px; height: 225px;" />
 * <pre>
 * <strong>Input:</strong> edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The longest path of the tree is the path 3 - 2 - 1 - 4 - 5.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>n == edges.length + 1</code></li>
 * <li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
 * <li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
 * <li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Tree</li><li>Depth-First Search</li><li>Breadth-First Search</li><li>list</li><li>Topological Sort</li></div></div><br><div><li>👍 723</li><li>👎 17</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int res = 0;

    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, isVisited);
        return res;
    }

    public int dfs(int curr, boolean[] isVisited) {
        int first = 0;
        int second = 0;
        isVisited[curr] = true;
        for (Integer item : graph.get(curr)) {
            if (isVisited[item]) {
                continue;
            }
            int len = dfs(item, isVisited);
            if (len > first) {
                second = first;
                first = len;
            } else if (len > second) {
                second = len;
            }
            res = Math.max(res, first + second);
        }
        return first + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
