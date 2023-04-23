708
        Insert into a Sorted Circular Linked List
        2023-01-04 18:03:20
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
        } else {
            Node currNode = head;
            while (!(insertVal <= currNode.next.val && insertVal >= currNode.val) && !(currNode.val > currNode.next.val && (insertVal >= currNode.val || insertVal <= currNode.next.val)) && currNode.next != head) {
                currNode = currNode.next;
            }
            Node temp = currNode.next;
            currNode.next = new Node(insertVal);
            currNode.next.next = temp;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
