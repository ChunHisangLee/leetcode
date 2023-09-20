//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @param {number} x
 * @return {number}
 */
var minOperations = function (nums, x) {
    const total = nums.reduce((a, b) => a + b);
    const n = nums.length;
    const target = total - x;
    let left = 0;
    let max = -1;
    let current = 0;

    for (let right = 0; right < n; right++) {
        current += nums[right];

        while (current > target && left <= right) {
            current -= nums[left];
            left++;
        }

        if (current == target) {
            max = Math.max(max, right - left + 1);
        }
    }

    return max === -1 ? max : n - max;
};
//leetcode submit region end(Prohibit modification and deletion)
