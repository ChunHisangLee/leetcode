
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (isSame(p1, p2) || isSame(p1, p3) || isSame(p1, p4) ||
                isSame(p2, p3) || isSame(p2, p4) || isSame(p3, p4)) {
            return false;
        }

        int[] distances = new int[6];
        distances[0] = dist(p1, p2);
        distances[1] = dist(p1, p3);
        distances[2] = dist(p1, p4);
        distances[3] = dist(p2, p3);
        distances[4] = dist(p2, p4);
        distances[5] = dist(p3, p4);

        Arrays.sort(distances);

        if (distances[0] == 0) {
            return false;
        }

        for (int i = 1; i < 4; i++) {
            if (distances[i] != distances[0]) {
                return false;
            }
        }

        if (distances[4] != distances[5]) {
            return false;
        }

        if (distances[4] <= distances[0]) {
            return false;
        }

        return true;
    }

    private int dist(int[] x, int[] y) {
        long dx = (long) (x[0] - y[0]);
        long dy = (long) (x[1] - y[1]);
        return (int) (dx * dx + dy * dy);
    }

    private boolean isSame(int[] x, int[] y) {
        return x[0] == y[0] && x[1] == y[1];
    }
}

//leetcode submit region end(Prohibit modification and deletion)
