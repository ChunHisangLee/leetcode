520
        Detect Capital
        2023-01-02 08:59:18

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        if (count == word.length() || count == 0) {
            return true;
        }
        return count == 1 && Character.isUpperCase(word.charAt(0));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
