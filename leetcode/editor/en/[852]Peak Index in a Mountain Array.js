//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} arr
 * @return {number}
 */
var peakIndexInMountainArray = function (arr) {
    let left = 0;
    let right = arr.length - 1;

    while (left <= right) {
        const mid = (left + right) >> 1;

        if (arr[mid] < arr[mid + 1]) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return left;
};
//leetcode submit region end(Prohibit modification and deletion)
