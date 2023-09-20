//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @param {number} x
 * @return {number}
 */
var minOperations = function (nums, x) {
    let total = nums.reduce((a, c) => a + c);
    const n = nums.length;
    const target = total - x;
    let max = -1;
    let left = 0;
    let current = 0;
    for (let right = 0; right < n; right++) {
        current += nums[right];

        while (current > target && left <= right) {
            current -= nums[left];
            left++;
        }
        if (current === target) {
            max = Math.max(max, right - left + 1);
        }
    }

    return max === -1 ? -1 : n - max;
};
//leetcode submit region end(Prohibit modification and deletion)
