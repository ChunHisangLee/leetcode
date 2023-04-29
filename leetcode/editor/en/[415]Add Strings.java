
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int i = c1.length - 1;
        int j = c2.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int temp = carry;
            if (i >= 0) {
                temp += c1[i] - '0';
            }
            if (j >= 0) {
                temp += c2[j] - '0';
            }
            sb.append(temp % 10);
            carry = temp / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
