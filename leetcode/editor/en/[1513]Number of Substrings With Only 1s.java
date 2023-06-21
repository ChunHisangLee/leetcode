
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSub(String s) {
        final int MOD = (int) 1e9 + 7;
        int count = 0;
        long res = 0;
        for (char c : s.toCharArray()) {
            count = c == '1' ? count + 1 : 0;
            res += count;
        }
        return (int) (res % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
