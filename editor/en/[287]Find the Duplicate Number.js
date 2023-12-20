//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function (nums) {
    const isDuplicated = new Array(nums.length).fill(false);

    for (const num of nums) {
        if (isDuplicated[num]) {
            return num;
        }

        isDuplicated[num] = true;
    }

    return -1;
};
//leetcode submit region end(Prohibit modification and deletion)
