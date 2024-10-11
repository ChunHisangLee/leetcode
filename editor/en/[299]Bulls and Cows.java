
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getHint(String secret, String guess) {
        int[] dp = new int[10];
        int bull = 0;
        int cow = 0;

        for (int i = 0; i < guess.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';

            if (s == g) {
                bull++;
            } else {
                if (dp[s] < 0) {
                    cow++;
                }

                if (dp[g] > 0) {
                    cow++;
                }

                dp[s]++;
                dp[g]--;
            }
        }
        return bull + "A" + cow + "B";
    }
}

//leetcode submit region end(Prohibit modification and deletion)
