2281
        Sum of Total Strength of Wizards
        2023-03-03 16:28:23

//leetcode submit region begin(Prohibit modification and deletion)
/*
Amazon 近半年很常考

Key words
Subarray + sum -> prefix sum
Subarray + minimum -> mono stack

 */
class Solution {
    public int totalStrength(int[] strength) {
        final int MOD = (int) 1e9 + 7;
        int n = strength.length;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(-1);
        int[] leftIndex = new int[n];
        int[] rightIndex = new int[n];
        Arrays.fill(rightIndex, n);

        for (int i = 0; i < n; i++) {
            while (dq.size() > 1 && strength[dq.peek()] >= strength[i]) {
                rightIndex[dq.pop()] = i;
            }
            leftIndex[i] = dq.peek();
            dq.push(i);
        }
        long sum = 0;
        long[] preSum = new long[n + 2];
        for (int i = 1; i <= n; i++) {
            sum += strength[i - 1];
            preSum[i + 1] = (int) ((preSum[i] + sum) % MOD);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            int leftBound = leftIndex[i] + 1;
            int rightBound = rightIndex[i] - 1;
            long ledtCount = i - leftBound + 1;
            long rightCount = rightBound - i + 1;
            long total = (ledtCount * (preSum[rightBound + 2] - preSum[i + 1]) - (rightCount) * (preSum[i + 1] - preSum[leftBound])) % MOD;
            res = (res + strength[i] * total) % MOD;
        }
        return (int) (res + MOD) % MOD;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
