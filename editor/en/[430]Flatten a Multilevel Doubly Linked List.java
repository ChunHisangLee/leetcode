430
        Flatten a Multilevel Doubly Linked List
        2023-01-04 14:26:13
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node dummy = new Node(0, null, head, null);
        dfs(dummy, head);
        dummy.next.prev = null;
        return dummy.next;
    }

    private Node dfs(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }
        curr.prev = prev;
        prev.next = curr;
        Node temp = curr.next;
        Node tail = dfs(curr, curr.child);
        curr.child = null;
        return dfs(tail, temp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
