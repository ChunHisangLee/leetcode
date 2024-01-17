
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }

        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int ans = 0;

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (low <= node.val && node.val <= high) {
                ans += node.val;
            }
            if (node.left != null && low < node.val) {
                stack.push(node.left);
            }
            if (node.right != null && node.val < high) {
                stack.push(node.right);
            }
        }

        return ans;
    }
}
 */