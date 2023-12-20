392
        Is Subsequence
        2022-11-23 14:17:52

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        char[] charOfS = s.toCharArray();
        char[] charOfT = t.toCharArray();

        while (i < charOfS.length && j < charOfT.length) {
            if (charOfS[i] == charOfT[j]) {
                i++;
            }
            j++;
        }

        return i == charOfS.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
