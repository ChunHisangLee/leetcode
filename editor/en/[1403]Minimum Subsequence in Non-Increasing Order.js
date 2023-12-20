//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var minSubsequence = function (nums) {
    let n = nums.length;
    let sum = 0;
    let prefixSum = 0;
    let result = [];

    nums.sort((a, b) => a - b);

    for (let i = 0; i < n; i++) {
        prefixSum += nums[i];
    }

    while (sum <= prefixSum) {
        sum += nums[n - 1];
        prefixSum -= nums[n - 1];
        result.push(nums[n - 1]);
        n--;
    }

    return result;
};
//leetcode submit region end(Prohibit modification and deletion)
