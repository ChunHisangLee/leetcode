
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPlaceBall(position, m, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean canPlaceBall(int[] position, int m, int minDist) {
        int count = 1;
        int lastPos = position[0];
        int n = position.length;

        for (int i = 1; i < n; i++) {
            if (position[i] - lastPos >= minDist) {
                count++;
                lastPos = position[i];

                if (count == m) {
                    return true;
                }
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
