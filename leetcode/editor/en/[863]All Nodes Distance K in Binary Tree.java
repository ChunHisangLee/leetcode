
//leetcode submit region begin(Prohibit modification and deletion)

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
        Set<Integer> isVisited = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{target.val, 0});
        isVisited.add(target.val);
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
                    if (!isVisited.contains(key)) {
                        dq.add(new int[]{key, dist + 1});
                        isVisited.add(key);
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
/*
-10ms
class Solution {
    List<Integer> ans = new ArrayList();
    int k;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.k = k;
        find(root, target.val, 0);
        return ans;
    }
    int find(TreeNode root, int target, int depth) {
        if (root == null) {
            return -1;
        }
        if (root.val == target) {
            traverse(root, 0, k);
            return depth;
        }
        int foundDepth = find(root.left, target, depth + 1);
        if (foundDepth != -1) {
            if (foundDepth - depth == k) {
                ans.add(root.val);
            } else if (foundDepth - depth < k) {
                traverse(root.right, 1, k - (foundDepth - depth));
            }
            return foundDepth;
        }
        foundDepth = find(root.right, target, depth + 1);
        if (foundDepth != -1) {
            if (foundDepth - depth == k) {
                ans.add(root.val);
            } else if (foundDepth - depth < k) {
                traverse(root.left, 1, k - (foundDepth - depth));
            }
        }
        return foundDepth;
    }
    void traverse(TreeNode root, int depth, int targetDepth) {
        if (root == null) {
            return;
        }
        if (depth == targetDepth) {
            ans.add(root.val);
            return;
        }
        traverse(root.left, depth + 1, targetDepth);
        traverse(root.right, depth + 1, targetDepth);
    }
}
 */