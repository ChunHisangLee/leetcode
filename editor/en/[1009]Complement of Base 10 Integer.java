
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int bitwiseComplement(int n) {
        int x = 1;
        while (x < n) {
            x = x * 2 + 1;
        }
        return x - n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
