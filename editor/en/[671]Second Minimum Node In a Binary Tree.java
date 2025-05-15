
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new TreeSet<>();
        dfs(root, set);
        int index = 0;

        for (int num : set) {
            if (index == 1) {
                return num;
            }

            index++;
        }

        return -1;
    }

    private void dfs(TreeNode node, Set<Integer> set) {
        if (node != null) {
            set.add(node.val);
            dfs(node.left, set);
            dfs(node.right, set);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
