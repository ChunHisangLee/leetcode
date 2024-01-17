//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minOperations = function (nums, k) {
    let xorSum = 0;

    for (let num of nums) {
        xorSum ^= num;
    }

    let diffBits = xorSum ^ k;
    const countBits = (n) => {
        let count = 0;
        while (n) {
            n &= (n - 1);
            count++;
        }

        return count;
    }

    return countBits(diffBits);
};
//leetcode submit region end(Prohibit modification and deletion)
