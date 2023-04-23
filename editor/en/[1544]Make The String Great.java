//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String makeGood(String s) {
        char[] ch = new char[s.length()];
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (left >= 0 && Math.abs(s.charAt(i) - ch[left]) == 32)
                left--;
            else
                ch[++left] = s.charAt(i);
        }
        char[] ans = new char[left + 1];
        while (left != -1) {
            ans[left] = ch[left];
            left--;
        }
        return new String(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
