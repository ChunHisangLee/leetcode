
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;
        int i = 0;
        int n = expression.length();

        while (i < n) {
            int sign = 1;

            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }

            int num = 0;

            while (i < n && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + (expression.charAt(i) - '0');
                i++;
            }

            num *= sign;
            i++;
            int denom = 0;

            while (i < n && Character.isDigit(expression.charAt(i))) {
                denom = denom * 10 + (expression.charAt(i) - '0');
                i++;
            }

            numerator = numerator * denom + num * denominator;
            denominator *= denom;

            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcd;
            denominator /= gcd;
        }

        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
