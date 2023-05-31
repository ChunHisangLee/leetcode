
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
    Map<Integer, List<Integer>> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, null);
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{target.val, 0});
        set.add(target.val);
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] curr = dq.poll();
                int node = curr[0];
                int dist = curr[1];
                if (dist == k) {
                    list.add(node);
                    continue;
                }
                for (int key : map.getOrDefault(node, new ArrayList<>())) {
                    if (!set.contains(key)) {
                        dq.add(new int[]{key, dist + 1});
                        set.add(key);
                    }
                }
            }
        }
        return list;
    }

    public void dfs(TreeNode curr, TreeNode parent) {
        if (curr != null && parent != null) {
            map.computeIfAbsent(curr.val, k -> new ArrayList<>()).add(parent.val);
            map.computeIfAbsent(parent.val, k -> new ArrayList<>()).add(curr.val);
        }
        if (curr != null && curr.left != null) {
            dfs(curr.left, curr);
        }
        if (curr != null && curr.right != null) {
            dfs(curr.right, curr);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
