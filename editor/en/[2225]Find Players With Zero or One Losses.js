//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[][]} matches
 * @return {number[][]}
 */
var findWinners = function (matches) {
    const loseCount = new Map();

    for (const [winner, loser] of matches) {
        loseCount.set(winner, loseCount.get(winner) || 0);
        loseCount.set(loser, (loseCount.get(loser) || 0) + 1);
    }

    const noLose = [];
    const oneLose = [];

    for (const [player, count] of loseCount) {
        if (count === 0) {
            noLose.push(player);
        } else if (count === 1) {
            oneLose.push(player);
        }
    }

    noLose.sort((a, b) => a - b);
    oneLose.sort((a, b) => a - b);
    return [noLose, oneLose];

};
//leetcode submit region end(Prohibit modification and deletion)
