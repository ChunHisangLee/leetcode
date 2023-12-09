94
Binary Tree
Inorder Traversal
        2022-12-02 11:49:52
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
