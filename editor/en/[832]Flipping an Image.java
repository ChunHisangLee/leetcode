
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            for (int i = 0; i < (row.length + 1) / 2; i++) {
                int temp = 1 - row[i];
                row[i] = 1 - row[row.length - 1 - i];
                row[row.length - 1 - i] = temp;
            }
        }

        return image;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
