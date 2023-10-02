
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean winnerOfGame(String colors) {
        int countA = 0;
        int countB = 0;
        char[] c = colors.toCharArray();

        for (int i = 2; i < c.length; i++) {
            if (c[i] == 'A' && c[i - 1] == 'A' && c[i - 2] == 'A') {
                countA++;
            }
            
            if (c[i] == 'B' && c[i - 1] == 'B' && c[i - 2] == 'B') {
                countB++;
            }
        }

        return countA > countB;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
