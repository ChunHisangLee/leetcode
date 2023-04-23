43
        Multiply Strings
        2022-11-25 13:23:37

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] arr = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = nums1[i] - '0';
                int d2 = nums2[j] - '0';
                arr[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = n1 + n2 - 1; i >= 0; i--) {
            int num = (arr[i] + carry) % 10;
            carry = (arr[i] + carry) / 10;
            arr[i] = num;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        while (sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
