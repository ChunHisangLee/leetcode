459
        Repeated Substring Pattern
        2022-11-23 09:51:49

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                if (s.charAt(i - 1) != s.charAt(len - 1)) {
                    continue;
                }
                String sub = s.substring(0, i);
                int m = len / i;
                int p = 1;
                while (p < m && sub.equals(s.substring(i * p, i * p + i))) p++;
                if (p == m) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(1, str.length() - 1));
        if (sb.toString().contains(s))
            return true;
        return false;
    }
}
 */