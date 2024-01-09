
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getItem(root1);
        List<Integer> list2 = getItem(root2);
        return list1.equals(list2);
    }

    private List<Integer> getItem(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        dfs(node, list);
        return list;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }

        dfs(node.left, list);
        dfs(node.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
