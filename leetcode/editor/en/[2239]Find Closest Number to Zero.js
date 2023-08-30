//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var findClosestNumber = function (nums) {
    let low = Infinity;
    let high = Infinity;
    for (const num of nums) {
        if (num === 0) {
            return 0;
        }
        if (num > 0) {
            high = Math.min(high, num);
        }
        if (num < 0) {
            low = Math.min(low, 0 - num);
        }
    }
    return high > low ? 0 - low : high;
};
//leetcode submit region end(Prohibit modification and deletion)
/*
var findClosestNumber = function (nums) {
    let index = 0;
    let diff = Infinity;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 0) {
            return nums[i];
        }
        let abs = Math.abs(nums[i]);
        if (abs < diff) {
            index = i;
            diff = abs;
        } else if (abs == diff && (nums[i] > 0 && nums[index] < 0)) {
            index = i;
        }
    }
    return nums[index];
};
 */