
/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public:
 * // Compares 4 different elements in the array
 * // return 4 if the values of the 4 elements are the same (0 or 1).
 * // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
 * // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.
 * public int query(int a, int b, int c, int d);
 * <p>
 * // Returns the length of the array
 * public int length();
 * };
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int guessMajority(ArrayReader reader) {
        int n = reader.length(), config = 0, one = 0, zero = 0;
        int[] g = new int[5];
        for (int i = 0; i < 5; i++) {
            int[] s = new int[]{(i + 1) % 5, (i + 2) % 5, (i + 3) % 5, (i + 4) % 5};
            Arrays.sort(s);
            g[i] = reader.query(s[0], s[1], s[2], s[3]);
        }
        for (int i = 0; i < 5 && ++config < 32; ) {
            one = Integer.bitCount(config);
            zero = 5 - one;
            for (i = 0; i < 5; i++) {
                if (g[i] != Math.abs(zero - one + ((config & (1 << (4 - i))) == 0 ? -1 : 1)))
                    break;
            }
        }
        int score = Math.abs(one - zero);
        int target = zero > one ? 0 : 1;
        int[] majority = new int[3];
        for (int i = 0, j = 0; j < 3; i++) {
            int cur = ((config & (1 << (4 - i))) > 0 ? 1 : 0);
            if (cur == target) {
                majority[j++] = i;
            }
        }
        int minority = -1;
        for (int i = 5; i < n - 1; i += 2) {
            int m = reader.query(majority[0], majority[1], i, i + 1);
            if (m == 0) {
                score -= 2;
                minority = i;
            } else if (m == 4) {
                score += 2;
            }
        }
        if (n % 2 == 0) {
            int m = reader.query(majority[0], majority[1], majority[2], n - 1);
            score += m == 4 ? 1 : -1;
        }
        if (score == 0)
            return -1;
        return score > 0 ? majority[0] : minority;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
