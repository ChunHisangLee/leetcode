// 117
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

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Node next = root;
        Node cur;
        Node prev = null;
        while (next != null) {
            cur = next;
            next = null;
            prev = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (prev != null)
                        prev.next = cur.left;
                    else
                        next = cur.left;
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (prev != null)
                        prev.next = cur.right;
                    else
                        next = cur.right;
                    prev = cur.right;
                }
                cur = cur.next;
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
