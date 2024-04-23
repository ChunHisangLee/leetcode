
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String smallest = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append((char) (node.val + 'a'));

        if (node.left == null && node.right == null) {
            String leafToRoot = sb.reverse().toString();
            sb.reverse();

            if (smallest == null || leafToRoot.compareTo(smallest) < 0) {
                smallest = leafToRoot;
            }
        }

        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
