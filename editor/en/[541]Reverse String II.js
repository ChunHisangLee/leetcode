//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reverseStr = function (s, k) {
    let c = s.split('');

    for (let i = 0; i < c.length; i += 2 * k) {
        let left = i;
        let right = Math.min(i + k - 1, c.length - 1);

        while (left < right) {
            [c[left], c[right]] = [c[right], c[left]];
            left++;
            right--;
        }
    }

    return c.join('');
};
//leetcode submit region end(Prohibit modification and deletion)
