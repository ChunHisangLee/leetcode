1071
        Greatest Common Divisor of Strings
        2023-02-01 09:29:16

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int max = gcd(n, m);
        return str1.substring(0, max);
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
