
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    int currCount = 0;
    int currVal = 0;
    int max = 0;

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);

        currCount = (node.val == currVal) ? currCount + 1 : 1;

        if (currCount == max) {
            list.add(node.val);
        } else if (currCount > max) {
            max = currCount;
            list.clear();
            list.add(node.val);
        }

        currVal = node.val;

        inOrderTraversal(node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int max = 0;
        dfs(root, map);

        for (int value : map.values()) {
            max = Math.max(max, value);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }

        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        dfs(node.left, map);
        dfs(node.right, map);
    }
}
 */