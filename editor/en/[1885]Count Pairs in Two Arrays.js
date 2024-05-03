//Given two integer arrays nums1 and nums2 of length n, count the pairs of
//indices (i, j) such that i < j and nums1[i] + nums1[j] > nums2[i] + nums2[j].
//
// Return the number of pairs satisfying the condition.
//
//
// Example 1:
//
//
//Input: nums1 = [2,1,2,1], nums2 = [1,2,1,2]
//Output: 1
//Explanation: The pairs satisfying the condition are:
//- (0, 2) where 2 + 2 > 1 + 1.
//
// Example 2:
//
//
//Input: nums1 = [1,10,6,2], nums2 = [1,4,1,5]
//Output: 5
//Explanation: The pairs satisfying the condition are:
//- (0, 1) where 1 + 10 > 1 + 4.
//- (0, 2) where 1 + 6 > 1 + 1.
//- (1, 2) where 10 + 6 > 4 + 1.
//- (1, 3) where 10 + 2 > 4 + 5.
//- (2, 3) where 6 + 2 > 1 + 5.
//
//
//
// Constraints:
//
//
// n == nums1.length == nums2.length
// 1 <= n <= 10⁵
// 1 <= nums1[i], nums2[i] <= 10⁵
//
//
// Related Topics Array Two Pointers Binary Search Sorting 👍 170 👎 12


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var countPairs = function (nums1, nums2) {
    let result = 0;
    const n = nums1.length;
    const nums = new Array(n).fill(0);

    for (let i = 0; i < n; i++) {
        nums[i] = nums1[i] - nums2[i];
    }

    nums.sort((a, b) => a - b);
    let left = 0;
    let right = n - 1;

    while (left < right) {
        if (nums[left] + nums[right] > 0) {
            result += right - left;
            right--;
        } else {
            left++;
        }
    }

    return result;
};
//leetcode submit region end(Prohibit modification and deletion)
