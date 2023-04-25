43
        Multiply Strings
        2022-11-25 13:23:37

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int len1 = c1.length;
        int len2 = c2.length;
        int[] prod = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int d1 = c1[i] - '0';
                int d2 = c2[j] - '0';
                prod[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = prod.length - 1; i >= 0; i--) {
            int temp = (prod[i] + carry) % 10;
            carry = (prod[i] + carry) / 10;
            prod[i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : prod) {
            sb.append(num);
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
