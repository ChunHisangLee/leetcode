58
        Length of Last Word
        2022-11-24 09:22:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        char[] c = s.toCharArray();
        int count = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == ' ') {
                return count;
            }
            count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
