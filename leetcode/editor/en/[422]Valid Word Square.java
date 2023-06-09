422
        Valid Word Square
        2023-03-01 09:40:40

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        char[][] c = new char[n][n];
        for (int i = 0; i < n; i++) {
            if (words.get(i).length() > n) {
                return false;
            }
            c[i] = Arrays.copyOf(words.get(i).toCharArray(), n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (c[i][j] != c[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
