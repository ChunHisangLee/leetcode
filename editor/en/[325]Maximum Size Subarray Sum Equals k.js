//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxSubArrayLen = function (nums, k) {
    const map = new Map();
    let max = 0;
    let sum = 0;

    map.set(0, -1);

    for (let i = 0; i < nums.length; i++) {
        sum += nums[i];

        if (map.has(sum - k)) {
            max = Math.max(max, i - map.get(sum - k));
        }

        if (!map.has(sum)) {
            map.set(sum, i);
        }
    }

    return max;
};
//leetcode submit region end(Prohibit modification and deletion)
