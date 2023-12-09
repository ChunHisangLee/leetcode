//leetcode submit region begin(Prohibit modification and deletion)
class BSTIterator {
    List<Integer> list = new ArrayList<>();
    int index = 0;

    public BSTIterator(TreeNode root) {

        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return list.size() > index ? true : false;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
