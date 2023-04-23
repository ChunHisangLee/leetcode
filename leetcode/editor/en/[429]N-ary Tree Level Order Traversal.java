429
        N-ary Tree Level Order Traversal
        2022-12-02 09:57:31

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
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return list;
        }
        dfs(root, 0);
        return list;
    }

    public void dfs(Node node, int level) {
        if (node == null) {
            return;
        }
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        for (Node child : node.children) {
            dfs(child, level + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
