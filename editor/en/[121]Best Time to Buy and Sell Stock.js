//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
    let cost = Infinity;
    let profit = 0;
    for (const price of prices) {
        cost = Math.min(cost, price);
        profit = Math.max(profit, price - cost);
    }
    return profit;
};
//leetcode submit region end(Prohibit modification and deletion)
