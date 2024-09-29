
//leetcode submit region begin(Prohibit modification and deletion)
class AllOne {
    private class Node {
        int count;
        Set<String> keys;
        Node prev;
        Node next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Node head;
    private Node tail;
    private Map<String, Node> keyCountMap;

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        keyCountMap = new HashMap<>();
    }

    public void inc(String key) {
        if (keyCountMap.containsKey(key)) {
            Node current = keyCountMap.get(key);
            int newCount = current.count + 1;
            Node nextNode = current.next;

            if (nextNode == tail || nextNode.count != newCount) {
                Node newNode = new Node(newCount);
                insertNodeAfter(newNode, current);
            }

            Node newNode = current.next;
            newNode.keys.add(key);
            keyCountMap.put(key, newNode);
            current.keys.remove(key);

            if (current.keys.isEmpty()) {
                removeNode(current);
            }
        } else {
            Node first = head.next;

            if (first == tail || first.count != 1) {
                Node newNode = new Node(1);
                insertNodeAfter(newNode, head);
            }

            Node node = head.next;
            node.keys.add(key);
            keyCountMap.put(key, node);
        }
    }

    public void dec(String key) {
        if (!keyCountMap.containsKey(key)) {
            return;
        }

        Node current = keyCountMap.get(key);
        if (current.count == 1) {
            current.keys.remove(key);
            keyCountMap.remove(key);

            if (current.keys.isEmpty()) {
                removeNode(current);
            }
        } else {
            int newCount = current.count - 1;
            Node prevNode = current.prev;

            if (prevNode == head || prevNode.count != newCount) {
                Node newNode = new Node(newCount);
                insertNodeAfter(newNode, current.prev);
            }

            Node newNode = current.prev;
            newNode.keys.add(key);
            keyCountMap.put(key, newNode);
            current.keys.remove(key);

            if (current.keys.isEmpty()) {
                removeNode(current);
            }
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }

        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }

        return head.next.keys.iterator().next();
    }

    private void insertNodeAfter(Node newNode, Node prevNode) {
        newNode.prev = prevNode;
        newNode.next = prevNode.next;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
//leetcode submit region end(Prohibit modification and deletion)
