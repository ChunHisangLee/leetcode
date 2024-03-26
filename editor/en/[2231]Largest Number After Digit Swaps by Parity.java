
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestInteger(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        PriorityQueue<Integer> even = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> odd = new PriorityQueue<>((a, b) -> b - a);

        for (char c : digits) {
            int n = c - '0';

            if (n % 2 == 0) {
                even.add(n);
            } else {
                odd.add(n);
            }
        }

        for (int i = 0; i < digits.length; i++) {
            if ((digits[i] - '0') % 2 == 0) {
                digits[i] = (char) (even.poll() + '0');
            } else {
                digits[i] = (char) (odd.poll() + '0');
            }
        }

        return Integer.parseInt(new String(digits));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
