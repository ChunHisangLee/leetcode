
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length();
        int points = m * n;
        int allKeys = 0;
        int startPoint = 0;
        for (int r = 0; r < m; r++) {
            String row = grid[r];
            for (int c = 0; c < n; c++) {
                char v = row.charAt(c);
                if (v == '@') {
                    startPoint = r * n + c;
                }
                boolean isKey = v >= 'a' && v <= 'f';
                if (isKey) {
                    allKeys = (allKeys << 1) | 1;
                }
            }
        }
        int states = points * (allKeys + 1);
        int[] queue = new int[states];
        int queueHead = 0;
        int queueTail = 0;
        boolean[] isVisited = new boolean[states];
        int distance = 0;
        int noKeys = 0;
        int startState = noKeys * points + startPoint;
        queue[queueHead++] = startState;
        isVisited[startState] = true;
        while (true) {
            int size = queueHead - queueTail;
            if (size == 0) {
                break;
            }
            while (--size >= 0) {
                int state = queue[queueTail++];
                int keys = state / points;
                int point = state % points;
                int row = point / n;
                int column = point % n;

                if (keys == allKeys) {
                    return distance;
                }
                for (int[] dir : dirs) {
                    int x = row + dir[0];
                    int y = column + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) {
                        continue;
                    }
                    char v = grid[x].charAt(y);
                    if (v == '#') {
                        continue;
                    }
                    int nextKey = keys;
                    if (v != '.') {
                        boolean isLock = v >= 'A' && v <= 'F';
                        if (isLock && !isOpen(keys, v)) {
                            continue;
                        }
                        boolean isKey = v >= 'a' && v <= 'f';
                        if (isKey) {
                            nextKey = addKey(nextKey, v);
                        }
                    }
                    int nextPoint = x * n + y;
                    int nextState = nextKey * points + nextPoint;
                    if (!isVisited[nextState]) {
                        queue[queueHead++] = nextState;
                        isVisited[nextState] = true;
                    }
                }
            }
            distance++;
        }
        return -1;
    }

    public int addKey(int keys, char key) {
        int keyId = 1 << (key - 'a');
        return keys | keyId;
    }

    public boolean isOpen(int keys, char lock) {
        int lockId = 1 << (lock - 'A');
        return (keys & lockId) > 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
