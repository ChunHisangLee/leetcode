//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxAncestorDiff = function (root) {
    const dfs = (node, max, min) => {
        if (node === null) {
            return max - min;
        }

        const currMax = Math.max(max, node.val);
        const currMin = Math.min(min, node.val);
        const left = dfs(node.left, currMax, currMin);
        const right = dfs(node.right, currMax, currMin);
        return Math.max(left, right);
    }

    return dfs(root, root.val, root.val);
};
//leetcode submit region end(Prohibit modification and deletion)
