
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Long> map = new HashMap<>();
        long count = 0;

        for (int[] rec : rectangles) {
            int x = rec[0];
            int y = rec[1];
            double ratio = (double) x / y;

            map.put(ratio, map.getOrDefault(ratio, 0L) + 1);
        }

        for (long num : map.values()) {
            if (num > 1) {
                count += num * (num - 1) / 2;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
