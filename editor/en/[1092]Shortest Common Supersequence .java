
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        
        while (i > 0 && j > 0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                lcs.append(str1.charAt(i-1));
                i--; j--;
            } else if (dp[i-1][j] >= dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        
        lcs.reverse();
        String lcsStr = lcs.toString();

        StringBuilder scs = new StringBuilder();
        i = 0;
        j = 0;

        for (char c : lcsStr.toCharArray()) {
            while (i < str1.length() && str1.charAt(i) != c) {
                scs.append(str1.charAt(i++));
            }

            while (j < str2.length() && str2.charAt(j) != c) {
                scs.append(str2.charAt(j++));
            }

            scs.append(c);
            i++;
            j++;
        }

        scs.append(str1.substring(i));
        scs.append(str2.substring(j));

        return scs.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
