# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getLonelyNodes(self, root: Optional[TreeNode]) -> List[int]:
        lonely_nodes = []
        self.dfs(root, lonely_nodes)
        return lonely_nodes

    def dfs(self, node, lonely_nodes):
        if node is None:
            return

        if node.left and not node.right:
            lonely_nodes.append(node.left.val)

        if node.right and not node.left:
            lonely_nodes.append(node.right.val)

        self.dfs(node.left, lonely_nodes)
        self.dfs(node.right, lonely_nodes)
# leetcode submit region end(Prohibit modification and deletion)
