//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumReplacement = function (nums) {
    let res = 0;
    const n = nums.length;
    let prev = nums[n - 1];
    for (let i = n - 2; i >= 0; i--) {
        let element = Math.floor(nums[i] / prev);
        if (nums[i] % prev !== 0) {
            element++;
            prev = Math.floor(nums[i] / element);
        }
        res += element - 1;
    }
    return res;
};
//leetcode submit region end(Prohibit modification and deletion)
