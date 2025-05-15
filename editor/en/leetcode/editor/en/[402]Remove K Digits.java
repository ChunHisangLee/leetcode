
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }

        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {
            while (stack.length() > 0 && k > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(digit);
        }

        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        String result = stack.toString().replaceFirst("^0+(?!$)", "");
        return result.isEmpty() ? "0" : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
