# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.smallest = None

    def smallestFromLeaf(self, root: Optional[TreeNode]) -> str:
        self.dfs(root, [])
        return self.smallest

    def dfs(self, node, path) -> None:
        if node is None:
            return

        path.append(chr(node.val + ord('a')))

        if node.left is None and node.right is None:
            leaf_to_root = ''.join(reversed(path))
            if self.smallest is None or leaf_to_root < self.smallest:
                self.smallest = leaf_to_root

        self.dfs(node.left, path)
        self.dfs(node.right, path)
        path.pop()
# leetcode submit region end(Prohibit modification and deletion)
