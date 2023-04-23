117
        Populating Next Right Pointers in Each Node II
        2022-12-02 18:26:28
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            Node next = null;
            for (int i = 0; i < size; i++) {
                Node node = dq.poll();
                node.next = next;
                next = node;
                if (node.right != null) {
                    dq.add(node.right);
                }
                if (node.left != null) {
                    dq.add(node.left);
                }

            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
