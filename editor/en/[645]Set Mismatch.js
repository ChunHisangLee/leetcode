//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findErrorNums = function (nums) {
    let set = new Set();
    let dup = 0;
    let miss = 0;
    let sum = 0;

    for (let num of nums) {
        if (set.has(num)) {
            dup = num;
        }

        set.add(num);
        sum += num;
    }

    miss = (nums.length) * (nums.length + 1) / 2 - sum + dup;
    return [dup, miss];
};
//leetcode submit region end(Prohibit modification and deletion)
