//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} customers
 * @return {number}
 */
var bestClosingTime = function (customers) {
    let currPenalty = 0;
    let minPenalty = 0;
    let minTime = 0;
    for (let i = 0; i < customers.length; i++) {
        if (customers.charAt(i) === 'Y') {
            currPenalty--;
        } else {
            currPenalty++;
        }
        if (currPenalty < minPenalty) {
            minPenalty = currPenalty;
            minTime = i + 1;
        }
    }
    return minTime;
};
//leetcode submit region end(Prohibit modification and deletion)
