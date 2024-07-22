
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();

        for (int val : to_delete) {
            set.add(val);
        }

        List<TreeNode> result = new ArrayList<>();

        if (!set.contains(root.val)) {
            result.add(root);
        }

        deleteNode(root, set, result);
        return result;
    }

    private TreeNode deleteNode(TreeNode node, Set<Integer> set, List<TreeNode> list) {
        if (node == null) {
            return null;
        }

        node.left = deleteNode(node.left, set, list);
        node.right = deleteNode(node.right, set, list);

        if (set.contains(node.val)) {
            if (node.left != null) {
                list.add(node.left);
            }

            if (node.right != null) {
                list.add(node.right);
            }

            return null;
        }

        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
