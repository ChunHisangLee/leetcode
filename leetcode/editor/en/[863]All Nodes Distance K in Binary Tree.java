
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, null);
        Deque<TreeNode> dq = new ArrayDeque<>();
        Set<TreeNode> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        dq.add(target);
        set.add(target);
        int level = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = dq.poll();
                if (level == k) {
                    list.add(curr.val);
                    continue;
                }
                if (map.get(curr) != null && !set.contains(map.get(curr))) {
                    dq.add(map.get(curr));
                    set.add(map.get(curr));
                }
                if (curr.left != null && !set.contains(curr.left)) {
                    dq.add(curr.left);
                    set.add(curr.left);
                }
                if (curr.right != null && !set.contains(curr.right)) {
                    dq.add(curr.right);
                    set.add(curr.right);
                }
            }
            if (level == k) {
                break;
            }
            level++;
        }
        return list;
    }

    private void dfs(TreeNode curr, TreeNode parent) {
        if (curr == null) {
            return;
        }
        map.put(curr, parent);
        dfs(curr.left, curr);
        dfs(curr.right, curr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
