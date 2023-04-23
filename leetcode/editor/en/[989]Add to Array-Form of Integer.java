989
        Add to Array-Form of Integer
        2022-11-26 11:13:11

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = num.length - 1;
        while (n >= 0 || k > 0) {
            if (n >= 0) {
                k += num[n];
            }
            list.addFirst(k % 10);
            k /= 10;
            n--;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
