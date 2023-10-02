//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var longestSubarray = function (nums) {
    let count = 0;
    let result = 0;
    let max = Math.max(...nums);

    for (const num of nums) {
        if (num === max) {
            count++;
            result = Math.max(result, count);
        } else {
            count = 0;
        }
    }

    return result;
};
//leetcode submit region end(Prohibit modification and deletion)
