
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int maxImbalance = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '[') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                maxImbalance = Math.max(maxImbalance, -balance);
            }
        }

        return (maxImbalance + 1) / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
