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
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {boolean}
 */
var leafSimilar = function (root1, root2) {
    const list1 = [];
    const list2 = [];
    dfs(root1, list1);
    dfs(root2, list2);
    return isEqual(list1, list2);
};

function dfs(root, list) {
    if (root === null) {
        return;
    }

    if (!root.left && !root.right) {
        list.push(root.val);
    }

    dfs(root.left, list);
    dfs(root.right, list);
}

function isEqual(arr1, arr2) {
    if (arr1.length !== arr2.length) {
        return false;
    }

    for (let i = 0; i < arr1.length; i++) {
        if (arr1[i] !== arr2[i]) {
            return false;
        }
    }

    return true;
}

//leetcode submit region end(Prohibit modification and deletion)
