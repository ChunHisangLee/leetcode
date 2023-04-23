class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        if (len == 2)
            return true;
        int deltaX = coordinates[0][0] - coordinates[1][0];
        int deltaY = coordinates[0][1] - coordinates[1][1];
        for (int i = 2; i < len; i++) {
            int curDeltaX = coordinates[i][0] - coordinates[0][0];
            int curDeltaY = coordinates[i][1] - coordinates[0][1];
            if (deltaX * curDeltaY != deltaY * curDeltaX)
                return false;
        }
        return true;
    }
}