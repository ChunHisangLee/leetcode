
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root = new Node("");

        for (List<String> path : paths) {
            Node cur = root;
            for (String seg : path) {
                cur = cur.children.computeIfAbsent(seg, Node::new);
            }
        }

        Map<String, List<Node>> serialMap = new HashMap<>(1024);
        serialize(root, serialMap);

        for (Map.Entry<String, List<Node>> e : serialMap.entrySet()) {
            String serial = e.getKey();
            if (serial.isEmpty()) {
                continue;
            }
            List<Node> list = e.getValue();
            if (list.size() > 1) {
                for (Node n : list) {
                    n.deleted = true;
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        Deque<String> cur = new ArrayDeque<>();
        collect(root, cur, ans);
        return ans;
    }

    private static final class Node {
        final String name;
        final Map<String, Node> children = new HashMap<>();
        boolean deleted;
        String serial;

        Node(String name) {
            this.name = name;
        }
    }

    private String serialize(Node node, Map<String, List<Node>> serialMap) {
        if (node.children.isEmpty()) {
            node.serial = "";
            serialMap.computeIfAbsent(node.serial, k -> new ArrayList<>()).add(node);
            return node.serial;
        }

        List<String> keys = new ArrayList<>(node.children.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String k : keys) {
            Node child = node.children.get(k);
            String childSerial = serialize(child, serialMap);
            sb.append('(').append(k).append(childSerial).append(')');
        }

        node.serial = sb.toString();
        serialMap.computeIfAbsent(node.serial, k -> new ArrayList<>()).add(node);
        return node.serial;
    }

    private void collect(Node node, Deque<String> path, List<List<String>> ans) {
        for (Node child : node.children.values()) {
            if (child.deleted) {
                continue;
            }
            path.addLast(child.name);
            ans.add(new ArrayList<>(path));
            collect(child, path, ans);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
