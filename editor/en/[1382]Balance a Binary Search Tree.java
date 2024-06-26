
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedNode = new ArrayList<>();
        inOrder(root, sortedNode);
        return buildBalancedBST(sortedNode, 0, sortedNode.size() - 1);
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    private TreeNode buildBalancedBST(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildBalancedBST(list, left, mid - 1);
        node.right = buildBalancedBST(list, mid + 1, right);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
