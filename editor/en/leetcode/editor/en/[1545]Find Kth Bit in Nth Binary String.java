
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char findKthBit(int n, int k) {
        return helper(n, k);
    }

    private char helper(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int length = (1 << (n - 1)) - 1;

        if (k <= length) {
            return helper(n - 1, k);
        } else if (k == length + 1) {
            return '1';
        } else {
            int posInRevInv = k - (length + 1);
            int originalPos = length - posInRevInv + 1;
            char bit = helper(n - 1, originalPos);
            return invert(bit);
        }
    }

    private char invert(char c) {
        return c == '0' ? '1' : '0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
