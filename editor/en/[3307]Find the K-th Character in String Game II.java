
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        long[] lens = new long[n + 1];
        lens[0] = 1;

        for (int i = 0; i < n; i++) {
            if (operations[i] == 0) {
                lens[i + 1] = lens[i] * 2;
            } else {
                lens[i + 1] = lens[i] * 2;
            }
            if (lens[i + 1] > k) lens[i + 1] = k;
        }

        int offset = 0;

        for (int i = n - 1; i >= 0; i--) {
            long len = lens[i];

            if (operations[i] == 0) {
                if (k > len) {
                    k -= len;
                }
            } else {
                if (k > len) {
                    k -= len;
                    offset++;
                }
            }
        }

        char c = 'a';
        c += offset;

        if (c > 'z') {
            c = (char) ('a' + (c - 'a') % 26);
        }

        return c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
