1490
        Clone N-ary Tree
        2023-02-04 14:31:10
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }
        return dfs(root);
    }

    Node dfs(Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node clone = new Node(node.val);
        map.put(node, clone);
        for (Node item : node.children) {
            clone.children.add(dfs(item));
        }
        return clone;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
