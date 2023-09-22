//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
    let m = nums1.length;
    let n = nums2.length;
    let result = 0;
    let list = [];

    for (const num of nums1) {
        list.push(num);
    }

    for (const num of nums2) {
        list.push(num);
    }

    list.sort((a, b) => a - b);

    let index = Math.floor((m + n) / 2);

    if (list.length % 2 === 0) {
        result = (list[index - 1] + list[index]) / 2;
    } else {
        result = list[index];
    }

    return result;
};
//leetcode submit region end(Prohibit modification and deletion)
