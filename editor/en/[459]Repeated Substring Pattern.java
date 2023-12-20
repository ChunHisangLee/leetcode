459
        Repeated Substring Pattern
        2022-11-23 09:51:49

/*
不熟練
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0 && s.charAt(i - 1) == s.charAt(n - 1)) {
                int m = n / i;
                String str = s.substring(0, i);
                if (str.repeat(m).equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)