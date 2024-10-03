//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int HASH_MULTIPLIER = 60001;

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> obstacleSet = new HashSet<>();

        for (int[] obstacle : obstacles) {
            obstacleSet.add(hashCoordinates(obstacle[0], obstacle[1]));
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0;
        int y = 0;
        int maxDistanceSquared = 0;
        int currentDirection = 0;

        for (int command : commands) {
            if (command == -1) {
                currentDirection = (currentDirection + 1) % 4;
            } else if (command == -2) {
                currentDirection = (currentDirection + 3) % 4;
            } else {
                for (int step = 0; step < command; step++) {
                    int nextX = x + directions[currentDirection][0];
                    int nextY = y + directions[currentDirection][1];
                    if (obstacleSet.contains(hashCoordinates(nextX, nextY))) {
                        break;
                    }

                    x = nextX;
                    y = nextY;
                    maxDistanceSquared = Math.max(maxDistanceSquared, x * x + y * y);
                }
            }
        }

        return maxDistanceSquared;
    }

    private int hashCoordinates(int x, int y) {
        return x + HASH_MULTIPLIER * y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
