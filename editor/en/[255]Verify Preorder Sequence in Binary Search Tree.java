
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> deque = new ArrayDeque<>();
        int lower = Integer.MIN_VALUE;

        for (int value : preorder) {
            if (value < lower) {
                return false;
            }

            while (!deque.isEmpty() && value > deque.peek()) {
                lower = deque.pop();
            }

            deque.push(value);
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
