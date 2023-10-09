//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function (nums, target) {
    if (nums.length === 0) {
        return [-1, -1];
    }

    let left = 0;
    let right = nums.length - 1;

    while (left <= right) {
        const mid = (left + right) >> 1;

        if (nums[mid] === target) {
            let leftIndex = mid;
            let rightIndex = mid;

            while (leftIndex >= 0 && nums[leftIndex] === target) {
                leftIndex--;
            }

            while (rightIndex < nums.length && nums[rightIndex] === target) {
                rightIndex++;
            }

            return [leftIndex + 1, rightIndex - 1];
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return [-1, -1];
};
//leetcode submit region end(Prohibit modification and deletion)
