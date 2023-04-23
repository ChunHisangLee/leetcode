559
        Maximum Depth of N-ary Tree
        2022-12-02 21:11:23
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
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            count++;
            for (int i = 0; i < size; i++) {
                Node curr = dq.poll();
                for (Node node : curr.children) {
                    if (node != null) {
                        dq.add(node);
                    }
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
0ms
class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node node : root.children) {
            max = Math.max(max, maxDepth(node));
        }
        return max + 1;
    }
}

2~3ms
class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            count++;
            for (int i = 0; i < size; i++) {
                Node curr = dq.poll();
                for (Node node : curr.children) {
                    if (node != null) {
                        dq.add(node);
                    }
                }
            }
        }
        return count;
    }
}
 */