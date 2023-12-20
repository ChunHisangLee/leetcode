
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countHomogenous(String s) {
        final int MOD = (int) 1e9 + 7;
        char curr = s.charAt(0);
        int result = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == curr) {
                count++;
            } else {
                count = 1;
            }

            curr = c;
            result = (result + count) % MOD;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
