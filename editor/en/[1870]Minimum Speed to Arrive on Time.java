// 1870
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int len = dist.length;
        int low = 1;
        int high = 1_000_000_1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isPossible(dist, hour, mid))
                high = mid;
            else
                low = mid + 1;
        }
        return low >= 1_000_000_1 ? -1 : low;
    }

    private boolean isPossible(int[] dist, double hour, int speed) {
        double total = 0.0;
        for (int i = 0; i < dist.length - 1; i++) {
            total += (dist[i] + speed - 1) / speed;
        }
        total += (double) dist[dist.length - 1] / (double) speed;
        return total <= hour;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
