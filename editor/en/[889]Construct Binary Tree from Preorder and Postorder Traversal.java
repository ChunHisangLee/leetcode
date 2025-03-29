
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    int preIndex;
    int postIndex;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode node = new TreeNode(preorder[preIndex]);
        preIndex++;

        if (node.val != postorder[postIndex]) {
            node.left = constructFromPrePost(preorder, postorder);
        }

    if (node.val != postorder[postIndex]) {
            node.right = constructFromPrePost(preorder, postorder);
        }

    postIndex++;
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
