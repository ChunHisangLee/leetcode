426
        Convert Binary Search Tree to Sorted Doubly Linked List
        2022-12-24 11:18:21
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node first = null;
    Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        last.right = first;
        first.left = last;
        return first;
    }

    private void dfs(Node node) {
        if (node != null) {
            dfs(node.left);
            if (last != null) {
                last.right = node;
                node.left = last;
            } else {
                first = node;
            }
            last = node;
            dfs(node.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Initiate the first and the last nodes as nulls.

Call the standard inorder recursion helper(root) :

    If node is not null :

        Call the recursion for the left subtree helper(node.left).

        If the last node is not null, link the last and the current node nodes.

        Else initiate the first node.

        Mark the current node as the last one : last = node.

        Call the recursion for the right subtree helper(node.right).

Link the first and the last nodes to close DLL ring and then return the first node.
 */