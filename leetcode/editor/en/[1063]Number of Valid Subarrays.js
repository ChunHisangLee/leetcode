//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var validSubarrays = function (nums) {
    let result = 0;
    let dq = [];

    for (let i = 0; i < nums.length; i++) {
        while (dq.length > 0 && nums[i] < nums[dq[dq.length - 1]]) {
            result += (i - dq[dq.length - 1]);
            dq.pop();
        }
        dq.push(i);
    }

    while ((dq.length > 0)) {
        result += (nums.length - dq[dq.length - 1]);
        dq.pop();
    }

    return result;
};
//leetcode submit region end(Prohibit modification and deletion)
