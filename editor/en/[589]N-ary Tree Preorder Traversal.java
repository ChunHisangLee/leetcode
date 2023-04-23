
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> result;

    public List<Integer> preorder(Node root) {
        result = new ArrayList<>();
        helper(root);
        return result;
    }

    private void helper(Node node) {
        if (node == null)
            return;
        result.add(node.val);
        for (Node child : node.children) {
            helper(child);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
