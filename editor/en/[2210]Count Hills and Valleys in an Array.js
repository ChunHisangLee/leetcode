//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var countHillValley = function (nums) {
    let count = 0;
    let left = nums[0];

    for (let i = 1; i < nums.length - 1; i++) {
        if ((nums[i] > left && nums[i] > nums[i + 1]) || (nums[i] < left && nums[i] < nums[i + 1])) {
            count++;
            left = nums[i];
        }
    }

    return count;
};
//leetcode submit region end(Prohibit modification and deletion)
