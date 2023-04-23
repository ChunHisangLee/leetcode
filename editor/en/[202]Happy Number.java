
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n);
        while (n != 1) {
            int temp = 0;
            while (n != 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = temp;
            if (list.contains(n)) {
                break;
            } else {
                list.add(n);
            }
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
