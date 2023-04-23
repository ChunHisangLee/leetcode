428
        Serialize and Deserialize N-ary Tree
        2022-12-02 22:08:12
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(Node root, StringBuilder sb) {
        if (root == null)
            return;
        sb.append((char) (root.val + '0'));
        for (Node child : root.children) {
            serializeHelper(child, sb);
        }
        sb.append('$');
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.isEmpty())
            return null;
        return deserializeHelper(data, new int[1]);
    }

    private Node deserializeHelper(String data, int[] ind) {
        if (ind[0] == data.length())
            return null;
        Node m = new Node(data.charAt(ind[0]) - '0', new ArrayList<>());
        ind[0]++;
        while (data.charAt(ind[0]) != '$') {
            m.children.add(deserializeHelper(data, ind));
        }
        ind[0]++;
        return m;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
