
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        char[] res = new char[n + 1];
        char[] str = s.toCharArray();

        int pos = 0;
        int i = n - 1;
        int right, j;
        while (i >= 0) {
            while (i >= 0 && str[i] == ' ') {
                i--;
            }
            right = i;
            while (i >= 0 && str[i] != ' ') {
                i--;
            }
            for (j = i + 1; j < right; j++) {
                res[pos++] = str[j];
            }
            if (j == right) {
                res[pos++] = str[j];
                res[pos++] = ' ';
            }
        }
        return new String(res, 0, pos - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
