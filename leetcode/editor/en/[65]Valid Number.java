65
        Valid Number
        2023-01-02 09:20:23

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        boolean isExp = false;
        boolean isDot = false;
        boolean isDigit = false;
        boolean isErr = false;
        boolean isSign = false;
        for (int i = 0; i < s.length() && !isErr; i++) {
            char c = s.charAt(i);
            if (c == 'e' || c == 'E') {
                isErr = isExp || !isDigit;
                isExp = true;
                isDot = false;
                isDigit = false;
                isSign = false;
            } else if (c == '+' || c == '-') {
                isErr = isSign || isDigit || isDot;
                isSign = true;
            } else if (c == '.') {
                isErr = isDot || isExp;
                isDot = true;
            } else if (Character.isDigit(c)) {
                isDigit = true;
            } else {
                isErr = true;
            }
        }
        return !isErr && isDigit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
