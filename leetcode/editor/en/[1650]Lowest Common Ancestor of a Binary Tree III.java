1650
        Lowest Common Ancestor of a Binary Tree III
        2022-12-27 16:53:21
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node x = p;
        Node y = q;
        while (x != y) {
            x = x == null ? q : x.parent;
            y = y == null ? p : y.parent;
        }
        return x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
