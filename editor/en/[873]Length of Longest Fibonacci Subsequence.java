// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int lenLongestFibSubseq(int[] arr) {
    int n = arr.length;
    Map<Integer, Integer> index = new HashMap<>();

    for (int i = 0; i < n; i++) {
      index.put(arr[i], i);
    }

    int[][] dp = new int[n][n];
    int ans = 0;

    for (int j = 0; j < n; j++) {
      for (int i = 0; i < j; i++) {
        dp[i][j] = 2;
        int potentialPrev = arr[j] - arr[i];

        if (potentialPrev < arr[i] && index.containsKey(potentialPrev)) {
          int k = index.get(potentialPrev);
          dp[i][j] = dp[k][i] + 1;
          ans = Math.max(ans, dp[i][j]);
        }
      }
    }

    return ans >= 3 ? ans : 0;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
