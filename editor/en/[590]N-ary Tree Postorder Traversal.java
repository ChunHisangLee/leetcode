590
        N-ary Tree Postorder Traversal
        2022-12-02 11:52:08
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
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        dfs(root);
        return list;
    }

    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        for (Node child : node.children) {
            dfs(child);
        }
        list.add(node.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
