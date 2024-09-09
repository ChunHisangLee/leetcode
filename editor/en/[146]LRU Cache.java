//leetcode submit region begin(Prohibit modification and deletion)
class Node {
    public int key;
    public int value;
    public Node prev;
    public Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node p) {
        Node pre = p.prev;
        Node nex = p.next;
        pre.next = nex;
        nex.prev = pre;
    }

    private void addNode(Node newNode) {
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node p = map.get(key);
        deleteNode(p);
        addNode(p);
        return p.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node c = map.get(key);
            deleteNode(c);
            c.value = value;
            addNode(c);
        } else {
            if (map.size() == capacity) {
                Node leastRecentlyUsed = tail.prev;
                deleteNode(leastRecentlyUsed);
                map.remove(leastRecentlyUsed.key);
            }
            Node newNode = new Node(key, value);
            addNode(newNode);
            map.put(key, newNode);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
