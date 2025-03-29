
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int j = 0;

        for (int i = 0; i < n && j < m; i++) {
            char c1 = str1.charAt(i);
            char target = str2.charAt(j);

            if (c1 == target) {
                j++;
            } else {
                char c1Inc = incrementChar(c1);

                if (c1Inc == target) {
                    j++;
                }
            }
        }

        return j == m;
    }

    private char incrementChar(char c) {
        if (c == 'z') {
            return 'a';
        } else {
            return (char) (c + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
