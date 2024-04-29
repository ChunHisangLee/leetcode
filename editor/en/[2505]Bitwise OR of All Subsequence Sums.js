//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var subsequenceSumOr = function (nums) {
    let result = BigInt(0);
    let sum = BigInt(0);

    for (const num of nums) {
        let bigNum = BigInt(num);
        sum += bigNum;
        result |= bigNum;
        result |= sum;
    }

    return Number(result);
};
//leetcode submit region end(Prohibit modification and deletion)
