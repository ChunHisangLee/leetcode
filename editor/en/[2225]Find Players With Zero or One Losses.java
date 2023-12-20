2225
        Find Players With Zero or One Losses
        2022-11-27 21:47:27

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            map.put(winner, map.getOrDefault(winner, 0));
            map.put(loser, map.getOrDefault(loser, 0) + 1);
        }
        List<List<Integer>> ans = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (Integer player : map.keySet()) {
            if (map.get(player) == 0)
                ans.get(0).add(player);
            else if (map.get(player) == 1) {
                ans.get(1).add(player);
            }
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
