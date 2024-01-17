
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> loseCount = new HashMap<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            loseCount.put(winner, loseCount.getOrDefault(winner, 0));
            loseCount.put(loser, loseCount.getOrDefault(loser, 0) + 1);
        }

        List<Integer> noLose = new ArrayList<>();
        List<Integer> oneLose = new ArrayList<>();

        for (int player : loseCount.keySet()) {
            if (loseCount.get(player) == 0) {
                noLose.add(player);
            } else if (loseCount.get(player) == 1) {
                oneLose.add(player);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        Collections.sort(noLose);
        Collections.sort(oneLose);
        result.add(noLose);
        result.add(oneLose);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
