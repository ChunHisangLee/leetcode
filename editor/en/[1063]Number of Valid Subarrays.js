//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var validSubarrays = function (nums) {
    let result = 0;
    let stack = [];

    for (let i = 0; i < nums.length; i++) {
        while (stack.length > 0 && nums[i] < nums[stack[stack.length - 1]]) {
            result += (i - stack[stack.length - 1]);
            stack.pop();
        }
        stack.push(i);
    }

    while ((stack.length > 0)) {
        result += (nums.length - stack[stack.length - 1]);
        stack.pop();
    }

    return result;
};
//leetcode submit region end(Prohibit modification and deletion)
