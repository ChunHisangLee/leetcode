105
        Construct Binary Tree from Preorder and Inorder Traversal
        2022-12-02 14:10:43
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
    int preIndex;
    int inIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    public TreeNode dfs(int[] preOrder, int[] inOrder, int stop) {
        if (inIndex >= inOrder.length || inOrder[inIndex] == stop) {
            return null;
        }
        TreeNode node = new TreeNode(preOrder[preIndex]);
        preIndex++;
        node.left = dfs(preOrder, inOrder, node.val);
        inIndex++;
        node.right = dfs(preOrder, inOrder, stop);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    int preorderIndex;
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderMap.get(rootValue) + 1, right);
        return root;
    }
}
 */