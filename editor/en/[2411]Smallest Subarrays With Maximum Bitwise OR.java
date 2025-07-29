
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int BITS = 31;

    public int[] smallestSubarrays(int[] nums) {
        final int n = nums.length;
        int[] answer = new int[n];
        int[] lastPos = new int[BITS];
        Arrays.fill(lastPos, -1);

        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b < BITS; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    lastPos[b] = i;
                }
            }

            int farthest = i;

            for (int b = 0; b < BITS; b++) {
                if (lastPos[b] != -1) {
                    farthest = Math.max(farthest, lastPos[b]);
                }
            }

            answer[i] = farthest - i + 1;
        }

        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
