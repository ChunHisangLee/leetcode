//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();
        Set<Integer> seen = new HashSet<>();
        deque.add(new int[]{x, 0});

        while (!deque.isEmpty()) {
            int[] curr = deque.poll();
            int currValue = curr[0];
            int currStep = curr[1];

            if (currValue == y) {
                return currStep;
            }

            if (!seen.add(currValue)) {
                continue;
            }

            if (currValue % 11 == 0) {
                deque.add(new int[]{currValue / 11, currStep + 1});
            }

            if (currValue % 5 == 0) {
                deque.add(new int[]{currValue / 5, currStep + 1});
            }

            if (currValue > 1) {
                deque.add(new int[]{currValue - 1, currStep + 1});
            }

            deque.add(new int[]{currValue + 1, currStep + 1});
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
