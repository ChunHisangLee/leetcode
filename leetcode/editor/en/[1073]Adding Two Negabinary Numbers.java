
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int m = arr1.length - 1;
        int n = arr2.length - 1;
        int carry = 0;
        while (m >= 0 || n >= 0 || carry != 0) {
            int sum = carry;
            if (m >= 0) {
                sum += arr1[m--];
            }
            if (n >= 0) {
                sum += arr2[n--];
            }
            list.add(0, sum & 1);
            carry = -(sum >> 1);
        }
        while (list.size() > 1 && list.get(0) == 0) {
            list.remove(0);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
