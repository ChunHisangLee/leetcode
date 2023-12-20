//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var countSubarrays = function (nums) {
    let count = 1;
    let length = 1;

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i - 1]) {
            length++;
        } else {
            length = 1;
        }

        count+=length;
    }

    return count;
};
//leetcode submit region end(Prohibit modification and deletion)
