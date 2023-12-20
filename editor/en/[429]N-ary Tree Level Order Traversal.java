429
        N-ary Tree Level Order Traversal
        2022-12-02 09:57:31

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
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return res;
        }
        dfs(root, 0);
        return res;
    }

    public void dfs(Node curr, int level) {
        if (curr == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(curr.val);
        for (Node node : curr.children) {
            dfs(node, level + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
             return res;
        }
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = dq.poll();
                list.add(curr.val);
                for (Node node : curr.children) {
                    if (node != null) {
                        dq.add(node);
                    }
                }
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
 */