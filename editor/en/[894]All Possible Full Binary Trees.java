/**
 * <p>Given an integer <code>n</code>, return <em>a list of all possible <strong>full binary trees</strong> with</em> <code>n</code> <em>nodes</em>. Each node of each tree in the answer must have <code>Node.val == 0</code>.</p>
 *
 * <p>Each element of the answer is the root node of one possible tree. You may return the final list of trees in <strong>any order</strong>.</p>
 *
 * <p>A <strong>full binary tree</strong> is a binary tree where each node has exactly <code>0</code> or <code>2</code> children.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/08/22/fivetrees.png" style="width: 700px; height: 400px;" />
 * <pre>
 * <strong>Input:</strong> n = 7
 * <strong>Output:</strong> [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 3
 * <strong>Output:</strong> [[0,0,0]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 20</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Dynamic Programming</li><li>Tree</li><li>Recursion</li><li>Memoization</li><li>Binary Tree</li></div></div><br><div><li>👍 3752</li><li>👎 268</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    Map<Integer, List<TreeNode>> dp = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        return dyP(n);
    }

    private List<TreeNode> dyP(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return Arrays.asList(new TreeNode());
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = dyP(i);
            List<TreeNode> right = dyP(n - 1 - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0, l, r);
                    res.add(root);
                }
            }
        }
        dp.put(n, res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Top-Down - 1 ms
class Solution {
    Map<Integer, List<TreeNode>> dp = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        return dyP(n);
    }

    private List<TreeNode> dyP(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return Arrays.asList(new TreeNode());
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = dyP(i);
            List<TreeNode> right = dyP(n - 1 - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0, l, r);
                    res.add(root);
                }
            }
        }
        dp.put(n, res);
        return res;
    }
}

Bottom-Up - 2 ms
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        List<List<TreeNode>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(1).add(new TreeNode(0));
        for (int count = 3; count <= n; count += 2) {
            for (int i = 1; i < count - 1; i += 2) {
                int j = count - 1 - i;
                for (TreeNode left : dp.get(i)) {
                    for (TreeNode right : dp.get(j)) {
                        TreeNode root = new TreeNode(0, left, right);
                        dp.get(count).add(root);
                    }
                }
            }
        }
        return dp.get(n);
    }
}
 */