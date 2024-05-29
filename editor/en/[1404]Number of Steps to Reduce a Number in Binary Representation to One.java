
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        int n = s.length();

        for (int i = n - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0';

            if (bit == 0 && carry == 0) {
                steps++;
            } else if (bit == 1 && carry == 1) {
                steps++;
                carry = 1;
            } else {
                steps += 2;
                carry = 1;
            }
        }

        if (carry == 1) {
            steps++;
        }

        return steps;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
