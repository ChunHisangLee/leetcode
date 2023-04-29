989
        Add to Array-Form of Integer
        2022-11-26 11:13:11

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int i = num.length - 1;
        int carry = 0;
        while (i >= 0 || k > 0 || carry == 1) {
            int temp = carry;
            if (i >= 0) {
                temp += num[i];
            }
            if (k > 0) {
                temp += k % 10;
                k /= 10;
            }
            list.addFirst(temp % 10);
            carry = temp / 10;
            i--;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
