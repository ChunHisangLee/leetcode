
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> xToYMap = new HashMap<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            xToYMap.computeIfAbsent(x, k -> new HashSet<>()).add(y);
        }

        int minArea = Integer.MAX_VALUE;
        int n = points.length;

        for (int i = 0; i < n - 1; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int area = Math.abs(y2 - y1) * Math.abs(x2 - x1);

                if (area < minArea) {
                    if (x1 != x2 && y1 != y2 && xToYMap.get(x1).contains(y2) && xToYMap.get(x2).contains(y1)) {
                        minArea = Math.min(minArea, area);

                        if (minArea == 1) {
                            return 1;
                        }
                    }
                }
            }
        }

        return minArea < Integer.MAX_VALUE ? minArea : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
