707
        Design Linked List
        2023-01-02 21:53:09

//leetcode submit region begin(Prohibit modification and deletion)
class MyLinkedList {
    public MyLinkedList() {
    }

    public int get(int index) {
     }

    public void addAtHead(int val) {
    }

    public void addAtTail(int val) {
    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)
/*
class DoublyListNode {
    int val;
    DoublyListNode next;
    DoublyListNode prev;

    DoublyListNode(int x) {
        val = x;
    }
}

class MyLinkedList {
    private DoublyListNode head;

    public MyLinkedList() {
        head = null;
    }

    private DoublyListNode getNode(int index) {
        DoublyListNode curr = head;
        for (int i = 0; i < index && curr != null; i++) {
            curr = curr.next;
        }
        return curr;
    }

    private DoublyListNode getTail() {
        DoublyListNode curr = head;
        while (curr != null && curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

    public int get(int index) {
        DoublyListNode curr = getNode(index);
        return curr == null ? -1 : curr.val;
    }

    public void addAtHead(int val) {
        DoublyListNode curr = new DoublyListNode(val);
        curr.next = head;
        if (head != null) {
            head.prev = curr;
        }
        head = curr;
        return;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        DoublyListNode prev = getTail();
        DoublyListNode curr = new DoublyListNode(val);
        prev.next = curr;
        curr.prev = prev;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        DoublyListNode prev = getNode(index - 1);
        if (prev == null) {
            return;
        }
        DoublyListNode curr = new DoublyListNode(val);
        DoublyListNode next = prev.next;
        curr.prev = prev;
        curr.next = next;
        prev.next = curr;
        if(next != null) {
            next.prev = curr;
        }
    }

    public void deleteAtIndex(int index) {
        DoublyListNode curr = getNode(index);
        if (curr == null) {
            return;
        }
        DoublyListNode prev = curr.prev;
        DoublyListNode next = curr.next;
        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }
        if (next != null) {
            next.prev = prev;
        }
    }
}
 */