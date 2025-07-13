
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int playerIndex = 0;
        int trainerIndex = 0;
        int result = 0;
        while (playerIndex < players.length && trainerIndex < trainers.length) {
            if (players[playerIndex] <= trainers[trainerIndex]) {
                playerIndex++;
                result++;
            }
            
            trainerIndex++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
