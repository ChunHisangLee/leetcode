14
Longest Common
Prefix
        2023-01-02 10:39:06

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefixString = strs[0];

        for (String str : strs) {
            while (str.indexOf(prefixString) != 0) {
                prefixString = prefixString.substring(0, prefixString.length() - 1);
            }
        }

        return prefixString;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
