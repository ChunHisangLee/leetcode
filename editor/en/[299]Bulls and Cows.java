// 299
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getHint(String secret, String guess) {
        int[] dp = new int[10];
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i))
                bull++;
            else {
                cow += dp[secret.charAt(i) - '0']++ < 0 ? 1 : 0;
                cow += dp[guess.charAt(i) - '0']-- > 0 ? 1 : 0;
            }
        }
        return new StringBuilder().append(bull).append("A").append(cow).append("B").toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
