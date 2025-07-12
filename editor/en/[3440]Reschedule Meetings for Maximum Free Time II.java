
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        final int n = startTime.length;

        int[] gap = new int[n + 1];
        gap[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gap[i] = startTime[i] - endTime[i - 1];
        }
        gap[n] = eventTime - endTime[n - 1];

        int m = n + 1;
        int[] prefixMax = new int[m];
        int[] suffixMax = new int[m];
        prefixMax[0] = gap[0];
        for (int i = 1; i < m; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], gap[i]);
        }
        suffixMax[m - 1] = gap[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], gap[i]);
        }

        int answer = prefixMax[m - 1];

        for (int i = 0; i < n; i++) {
            int len = endTime[i] - startTime[i];

            int leftGapIdx = (i == 0) ? 0 : i;
            int rightGapIdx = (i == n - 1) ? n : i + 1;

            int bigGap = gap[leftGapIdx] + len + gap[rightGapIdx];

            int leftMax = (leftGapIdx == 0) ? 0 : prefixMax[leftGapIdx - 1];
            int rightMax = (rightGapIdx == m - 1) ? 0 : suffixMax[rightGapIdx + 1];
            int maxOther = Math.max(leftMax, rightMax);

            int bestAfterMove;
            if (maxOther >= len) {
                int shrinked = maxOther - len;
                int otherMaxAfterShrink = (maxOther == leftMax) ? rightMax : leftMax;
                bestAfterMove = Math.max(bigGap, Math.max(shrinked, otherMaxAfterShrink));
            } else {
                bestAfterMove = Math.max(bigGap - len, maxOther);
            }

            answer = Math.max(answer, bestAfterMove);
        }

        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
