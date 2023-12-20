145
Binary Tree
Postorder Traversal
        2022-12-02 11:52:01

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        postOrder(node.left, list);
        postOrder(node.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        dfs(node.right);
        list.add(node.val);
    }
}
 */