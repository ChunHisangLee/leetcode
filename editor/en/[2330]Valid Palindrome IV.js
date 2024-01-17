//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {boolean}
 */
var makePalindrome = function (s) {
    let count = 0;
    let left = 0;
    let right = s.length - 1;

    while (left < right) {
        if (s[left] !== s[right]) {
            count++;

            if (count > 2) {
                return false;
            }
        }

        left++;
        right--;
    }

    return true;
};
//leetcode submit region end(Prohibit modification and deletion)
