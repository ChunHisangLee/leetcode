//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
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
//leetcode submit region end(Prohibit modification and deletion)
