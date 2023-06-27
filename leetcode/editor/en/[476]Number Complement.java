
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findComplement(int num) {
        int x = 1;
        while (x < num) {
            x = x * 2 + 1;
        }
        return x - num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
