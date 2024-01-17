//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumOperations = function (nums) {
    let count = 0;
    let left = 0;
    let right = nums.length - 1;

    while (left < right) {
        if (nums[left] == nums[right]) {
            left++;
            right--;
        } else if (nums[left] < nums[right]) {
            nums[left + 1] += nums[left];
            left++;
            count++;
        } else {
            nums[right - 1] += nums[right];
            right--;
            count++;
        }
    }

    return count;
};
//leetcode submit region end(Prohibit modification and deletion)
