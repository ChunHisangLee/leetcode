
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};   //  order matters
        int x = 0;
        int y = 0;
        int index = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                index = (index + 3) % 4;
            } else if (c == 'R') {
                index = (index + 1) % 4;
            } else {
                x += dirs[index][0];
                y += dirs[index][1];
            }
        }
        return (x == 0 && y == 0) || (index != 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
