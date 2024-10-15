
//leetcode submit region begin(Prohibit modification and deletion)
class SnakeGame {
    private int width, height, score;
    private int[][] food;
    private int foodIndex;
    private LinkedList<int[]> snake;
    private Set<String> snakePositions;
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodIndex = 0;
        this.score = 0;

        this.snake = new LinkedList<>();
        this.snake.add(new int[]{0, 0});

        this.snakePositions = new HashSet<>();
        this.snakePositions.add("0_0");
    }

    public int move(String direction) {
        int[] head = snake.peekFirst();
        int headRow = head[0], headCol = head[1];
        int[] dir = getDirection(direction);
        int newRow = headRow + dir[0];
        int newCol = headCol + dir[1];

        if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width) {
            return -1;
        }

        String newHeadPosition = newRow + "_" + newCol;
        int[] tail = snake.peekLast();
        boolean isFood = foodIndex < food.length && newRow == food[foodIndex][0] && newCol == food[foodIndex][1];

        if (!isFood) {
            snakePositions.remove(tail[0] + "_" + tail[1]);
            snake.pollLast();
        }

        if (snakePositions.contains(newHeadPosition)) {
            return -1;
        }

        // Add the new head position
        snake.addFirst(new int[]{newRow, newCol});
        snakePositions.add(newHeadPosition);

        if (isFood) {
            score++;
            foodIndex++;
        }

        return score;
    }

    private int[] getDirection(String direction) {
        switch (direction) {
            case "U":
                return directions[0];
            case "D":
                return directions[1];
            case "L":
                return directions[2];
            case "R":
                return directions[3];
            default:
                throw new IllegalArgumentException("Invalid direction");
        }
    }
}


/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
//leetcode submit region end(Prohibit modification and deletion)
