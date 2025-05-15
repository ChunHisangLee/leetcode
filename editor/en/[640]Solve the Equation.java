
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        String left = parts[0];
        String right = parts[1];
        int[] leftParsed = parseExpression(left);
        int[] rightParsed = parseExpression(right);
        int netX = leftParsed[0] - rightParsed[0];
        int netConst = rightParsed[1] - leftParsed[1];

        if (netX == 0) {
            if (netConst == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            int xValue = netConst / netX;
            return "x=" + xValue;
        }
    }

    private int[] parseExpression(String expr) {
        int coeff = 0;
        int constant = 0;
        int n = expr.length();
        int i = 0;

        while (i < n) {
            int sign = 1;

            if (expr.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if (expr.charAt(i) == '-') {
                sign = -1;
                i++;
            }

            int num = 0;
            boolean hasNum = false;

            while (i < n && Character.isDigit(expr.charAt(i))) {
                num = num * 10 + (expr.charAt(i) - '0');
                i++;
                hasNum = true;
            }

            if (i < n && expr.charAt(i) == 'x') {
                i++;

                if (hasNum) {
                    coeff += sign * num;
                } else {
                    coeff += sign;
                }
            } else {
                constant += sign * num;
            }
        }

        return new int[]{coeff, constant};
    }
}

//leetcode submit region end(Prohibit modification and deletion)
