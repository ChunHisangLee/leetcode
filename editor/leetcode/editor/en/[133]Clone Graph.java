// leetcode submit region begin(Prohibit modification and deletion)
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
    return cloneDFS(node, map);
  }

  private Node cloneDFS(Node node, Map<Node, Node> map) {
    if (map.containsKey(node)) {
      return map.get(node);
    }

    Node cloneNode = new Node(node.val);
    map.put(node, cloneNode);

    for (Node neighbor : node.neighbors) {
      map.get(node).neighbors.add(cloneDFS(neighbor, map));
    }

    return cloneNode;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
