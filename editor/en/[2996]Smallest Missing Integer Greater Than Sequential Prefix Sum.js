//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var missingInteger = function (nums) {
    let sum = nums[0];
    const isContained = (nums, sum) => {
        for (const num of nums) {
            if (num === sum) {
                return true;
            }
        }

        return false;
    }

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] !== nums[i - 1] + 1) {
            break;
        }

        sum += nums[i];
    }

    while (isContained(nums, sum)) {
        sum++;
    }

    return sum;
};
//leetcode submit region end(Prohibit modification and deletion)
