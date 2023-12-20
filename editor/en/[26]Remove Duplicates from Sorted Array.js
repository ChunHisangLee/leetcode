
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
    let count = 1;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] != nums[count - 1]) {
            nums[count] = nums[i];
            count++;
        }
    }
    return count;
};
//leetcode submit region end(Prohibit modification and deletion)
