106
        Construct Binary Tree from Inorder and Postorder Traversal
        2022-12-02 13:52:51
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
/*
目前不會
 */
class Solution {
    int inIndex;
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inIndex = inorder.length - 1;
        postIndex = postorder.length - 1;
        return dfs(inorder, postorder, Integer.MAX_VALUE);
    }

    public TreeNode dfs(int[] inOrder, int[] postOrder, int stop) {
        if (inIndex < 0 || inOrder[inIndex] == stop) {
            return null;
        }
        TreeNode node = new TreeNode(postOrder[postIndex]);
        postIndex--;
        node.right = dfs(inOrder, postOrder, node.val);
        inIndex--;
        node.left = dfs(inOrder, postOrder, stop);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
  int postIndex;
  int[] postorder;
  int[] inorder;
  HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

  public TreeNode dfs(int in_left, int in_right) {
    // if there is no elements to construct subtrees
    if (in_left > in_right)
      return null;

    // pick up postIndex element as a root
    int root_val = postorder[postIndex];
    TreeNode root = new TreeNode(root_val);

    // root splits inorder list
    // into left and right subtrees
    int index = idx_map.get(root_val);

    // recursion
    postIndex--;
    // build right subtree
    root.right = dfs(index + 1, in_right);
    // build left subtree
    root.left = dfs(in_left, index - 1);
    return root;
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    this.postorder = postorder;
    this.inorder = inorder;
    // start from the last postorder element
    postIndex = postorder.length - 1;

    // build a hashmap value -> its index
    int idx = 0;
    for (Integer val : inorder)
      idx_map.put(val, idx++);
    return dfs(0, inorder.length - 1);
  }
}
 */