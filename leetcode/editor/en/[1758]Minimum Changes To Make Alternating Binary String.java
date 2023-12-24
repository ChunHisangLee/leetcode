
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(String s) {
        return Math.min(countChange(s, '0'), countChange(s, '1'));
    }

    private int countChange(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                count++;
            }
            c = c == '0' ? '1' : '0';
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
