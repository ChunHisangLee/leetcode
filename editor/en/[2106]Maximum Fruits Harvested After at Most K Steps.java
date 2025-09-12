
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        List<int[]> list = new ArrayList<>();
        int leftBound = startPos - k, rightBound = startPos + k;
        for (int[] f : fruits) {
            int pos = f[0];
            if (pos < leftBound) {
                continue;
            }
            if (pos > rightBound) {
                break;
            }
            list.add(f);
        }
        int n = list.size();
        if (n == 0) {
            return 0;
        }

        int[] pos = new int[n];
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int[] cur = list.get(i);
            pos[i] = cur[0];
            preSum[i + 1] = preSum[i] + cur[1];
        }

        long ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            while (l <= r && !withinSteps(pos[l], pos[r], startPos, k)) {
                l++;
            }
            if (l > r) {
                continue;
            }

            long total = preSum[r + 1] - preSum[l];
            ans = Math.max(ans, total);
        }
        return (int) ans;
    }

    private boolean withinSteps(int leftPos, int rightPos, int startPos, int k) {
        int stepsOption1 = (startPos - leftPos) * 2 + (rightPos - startPos);
        int stepsOption2 = (rightPos - startPos) * 2 + (startPos - leftPos);
        return Math.min(stepsOption1, stepsOption2) <= k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
