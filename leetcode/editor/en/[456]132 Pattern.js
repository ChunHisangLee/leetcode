//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var find132pattern = function (nums) {
    if (nums.length < 3) {
        return false;
    }

    let second = Number.MIN_SAFE_INTEGER;
    let stack = [];

    for (let i = nums.length - 1; i >= 0; i--) {
        if (nums[i] < second) {
            return true;
        }

        while (stack.length > 0 && stack[stack.length - 1] < nums[i]) {
            second = stack.pop();
        }

        stack.push(nums[i]);
    }

    return false;
};
//leetcode submit region end(Prohibit modification and deletion)
