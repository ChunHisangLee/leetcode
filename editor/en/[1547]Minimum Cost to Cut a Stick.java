
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>();
        for (int num : cuts) {
            list.add(num);
        }
        list.add(0);
        list.add(n);
        Collections.sort(list);
        int k = list.size();
        int[][] dp = new int[k][k];
        for (int d = 2; d < k; d++) {
            for (int i = 0; i < k - d; i++) {
                dp[i][i + d] = Integer.MAX_VALUE;
                for (int m = i + 1; m < i + d; m++) {
                    dp[i][i + d] = Math.min(dp[i][i + d], dp[i][m] + dp[m][i + d] + list.get(i + d) - list.get(i));
                }
            }
        }
        return dp[0][k - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Bottom-up
class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>();
        for (int num : cuts) {
            list.add(num);
        }
        list.add(0);
        list.add(n);
        Collections.sort(list);
        int k = list.size();
        int[][] dp = new int[k][k];
        for (int d = 2; d < k; d++) {
            for (int i = 0; i < k - d; i++) {
                dp[i][i + d] = Integer.MAX_VALUE;
                for (int m = i + 1; m < i + d; m++) {
                    dp[i][i + d] = Math.min(dp[i][i + d], dp[i][m] + dp[m][i + d] + list.get(i + d) - list.get(i));
                }
            }
        }
        return dp[0][k - 1];
    }
}

Top-Down
class Solution {
    int[][] dp;
    List<Integer> list;

    public int minCost(int n, int[] cuts) {
        list = new ArrayList<>();
        for (int num : cuts) {
            list.add(num);
        }
        list.add(0);
        list.add(n);
        Collections.sort(list);
        int k = list.size();
        dp = new int[k][k];
        for (int d = 2; d < k; d++) {
            for (int i = 0; i < k - d; i++) {
                dp[i][i + d] = dyP(i, i + d);
            }
        }
        return dp[0][k - 1];
    }

    public int dyP(int i, int j) {
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int m = i + 1; m < j; m++) {
            dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m][j] + list.get(j) - list.get(i));
        }
        return dp[i][j];
    }
}
 */