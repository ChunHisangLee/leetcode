
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char kthCharacter(int k) {
        int len = 1;
        int round = 0;

        while (len < k) {
            len *= 2;
            round++;
        }

        int offset = 0;

        while (len > 1) {
            int half = len / 2;

            if (k > half) {
                k -= half;
                offset++;
            }

            len /= 2;
        }

        char ch = 'a';
        ch += offset;

        if (ch > 'z') {
            ch -= 26;
        }

        return ch;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
