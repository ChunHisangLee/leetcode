371
        Sum of Two Integers
        2023-01-13 17:35:19

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int res = a ^ b;
            int carry = (a & b) << 1;
            a = res;
            b = carry;
        }
        return a;
    }
}
 */