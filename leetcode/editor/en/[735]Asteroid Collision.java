
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int num : asteroids) {
            boolean isPushed = true;
            while (!dq.isEmpty() && dq.peek() > 0 && num < 0) {
                int curr = dq.peek();
                if (curr >= -num) {
                    if (curr == -num) {
                        dq.pop();
                    }
                    isPushed = false;
                    break;
                } else {
                    dq.pop();
                }
            }
            if (isPushed) {
                dq.push(num);
            }
        }
        int[] arr = new int[dq.size()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = dq.pop();
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
