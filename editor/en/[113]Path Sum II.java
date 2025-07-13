
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        checkPathSum(root, targetSum, new ArrayList<>());
        return result;
    }

    private void checkPathSum(TreeNode node, int targetSum, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);

        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(list));
        } else {
            checkPathSum(node.left, targetSum - node.val, list);
            checkPathSum(node.right, targetSum - node.val, list);
        }

        list.remove(list.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
