# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def addOneRow(self, root: Optional[TreeNode], val: int, depth: int) -> Optional[TreeNode]:
        if depth == 1:
            new_root = TreeNode(val)
            new_root.left = root
            return new_root

        self.insert_at_depth(root, val, depth)
        return root

    def insert_at_depth(self, node: Optional[TreeNode], val: int, depth: int) -> None:
        if node is None:
            return

        if depth == 2:
            temp_left = node.left
            temp_right = node.right
            node.left = TreeNode(val, temp_left, None)
            node.right = TreeNode(val, None, temp_right)
        else:
            self.insert_at_depth(node.left, val, depth - 1)
            self.insert_at_depth(node.right, val, depth - 1)
# leetcode submit region end(Prohibit modification and deletion)
