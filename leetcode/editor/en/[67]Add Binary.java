67
        Add Binary
        2022-11-23 22:21:47

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int i = ca.length - 1;
        int j = cb.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int temp = carry;
            if (i >= 0) {
                temp += ca[i] - '0';
            }
            if (j >= 0) {
                temp += cb[j] - '0';
            }
            sb.append(temp % 2);
            carry = temp / 2;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger sum = x.add(y);
        return sum.toString(2);
    }
}

 */