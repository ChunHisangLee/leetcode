297
        Serialize and Deserialize Binary Tree
        2022-12-02 18:39:42
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
import java.util.StringTokenizer;

class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null ");
        } else {
            sb.append(root.val).append(" ");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        StringTokenizer st = new StringTokenizer(data);
        TreeNode root = deserialize(st);
        return root;
    }

    private TreeNode deserialize(StringTokenizer st) {
        String token = st.nextToken();
        TreeNode root;

        if (token.equals("null")) {
            root = null;
        } else {
            root = new TreeNode(Integer.parseInt(token));
            root.left = deserialize(st);
            root.right = deserialize(st);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
