
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        getList(root1, list1);
        getList(root2, list2);
        return list1.equals(list2);
    }

    private void getList(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(node.val);
        }

        getList(node.left, list);
        getList(node.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
