907
        Sum of Subarray Minimums
        2022-11-25 09:36:08

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.size() > 0) {
                int preMin = stack.peek();
                dp[i] = dp[preMin] + (i - preMin) * arr[i];
            } else
                dp[i] = (i + 1) * arr[i];
            stack.push(i);
        }
        long sum = 0;
        for (int item : dp) {
            sum += item;
            sum %= MOD;
        }
        return (int) sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
