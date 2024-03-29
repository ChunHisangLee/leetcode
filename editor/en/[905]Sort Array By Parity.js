//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArrayByParity = function (nums) {
    let left = 0;
    let right = nums.length - 1;

    while (left < right) {
        if (nums[left] % 2 === 0) {
            left++;
        } else if (nums[right] % 2 !== 0) {
            right--;
        } else {
            let temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

    return nums;
};
//leetcode submit region end(Prohibit modification and deletion)
