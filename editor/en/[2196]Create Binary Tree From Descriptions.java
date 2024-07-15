
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;

            TreeNode parent = map.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode child = map.getOrDefault(childVal, new TreeNode(childVal));

            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            map.put(parentVal, parent);
            map.put(childVal, child);
            children.add(childVal);
        }

        TreeNode root = new TreeNode(-1);

        for (int val : map.keySet()) {
            if (!children.contains(val)) {
                root = map.get(val);
                break;
            }
        }

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
