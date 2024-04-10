
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = deck.length - 1; i >= 0; i--) {
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }

            queue.add(deck[i]);
        }

        int[] result = new int[deck.length];

        for (int i = deck.length - 1; i >= 0; i--) {
            result[i] = queue.poll();
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
