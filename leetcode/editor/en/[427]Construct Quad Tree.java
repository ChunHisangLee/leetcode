427
        Construct Quad Tree
        2023-02-27 09:16:54
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, grid.length, 0, 0);
    }

    private Node helper(int[][] grid, int len, int x, int y) {
        if (len == 1) {
            return new Node(grid[x][y] == 1 ? true : false, true);
        }
        Node topLeft = helper(grid, len / 2, x, y);
        Node topRight = helper(grid, len / 2, x, y + len / 2);
        Node bottomLeft = helper(grid, len / 2, x + len / 2, y);
        Node bottomRight = helper(grid, len / 2, x + len / 2, y + len / 2);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
