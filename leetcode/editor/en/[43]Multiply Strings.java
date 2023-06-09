43
        Multiply Strings
        2022-11-25 13:23:37

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] arr = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = n2 - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                arr[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = (arr[i] + carry) % 10;
            carry = (arr[i] + carry) / 10;
            arr[i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
