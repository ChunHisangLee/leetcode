
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public long wonderfulSubstrings(String word) {
        long res = 0;
        int n = word.length();
        long[] count = new long[1024];
        count[0] = 1;
        int curr = 0;

        for (int i = 0; i < n; i++) {
            curr ^= 1 << (word.charAt(i) - 'a');
            res += count[curr];

            for (int j = 0; j < 10; j++) {
                res += count[curr ^ (1 << j)];
            }

            count[curr]++;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
