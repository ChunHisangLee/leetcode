
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSub(String s) {
        final int MOD = (int) 1e9 + 7;
        int result = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            } else {
                count = 0;
            }

            result = (result + count) % MOD;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
