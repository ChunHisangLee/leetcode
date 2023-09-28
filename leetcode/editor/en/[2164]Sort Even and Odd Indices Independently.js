//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortEvenOdd = function (nums) {
    const n = nums.length;
    let even = [];
    let odd = [];
    let arr = [];

    for (let i = 0; i < n; i++) {
        if (i % 2 === 0) {
            even.push(nums[i]);
        } else {
            odd.push(nums[i]);
        }
    }

    even.sort((o1, o2) => o1 - o2);
    odd.sort((o1, o2) => o2 - o1);

    for (let i = 0; i < n; i++) {
        if (i % 2 === 0) {
            arr[i] = even.shift();
        } else {
            arr[i] = odd.shift();
        }
    }

    return arr;
};
//leetcode submit region end(Prohibit modification and deletion)
