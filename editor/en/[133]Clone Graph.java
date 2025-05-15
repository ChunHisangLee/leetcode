//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }

    Map<Node, Node> map = new HashMap<>();
    Queue<Node> queue = new ArrayDeque<>();

    map.put(node, new Node(node.val));
    queue.offer(node);

    while (!queue.isEmpty()) {
      Node curr = queue.poll();

      for (Node nei : curr.neighbors) {
        if (!map.containsKey(nei)) {
          map.put(nei, new Node(nei.val));
          queue.offer(nei);
        }

        map.get(curr).neighbors.add(map.get(nei));
      }
    }

    return map.get(node);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
/*

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Deque<Node> dq = new ArrayDeque<>();
        map.put(node, new Node(node.val));
        dq.add(node);
        while (!dq.isEmpty()) {
            Node curr = dq.poll();
            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    dq.add(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}

class Solution {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node clone = new Node(node.val);
        map.put(node, clone);
        for (Node item : node.neighbors) {
            clone.neighbors.add(cloneGraph(item));
        }
        return clone;
    }
}
 */
