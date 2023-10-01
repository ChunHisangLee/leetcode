//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function (s) {
    return s.split(' ').map(word => word.split('').reverse().join('')).join(' ');
};


//leetcode submit region end(Prohibit modification and deletion)
/*
var reverseWords = function (s) {
    const c = s.split('');
    let left = 0;
    let right = 0;

    while (right < c.length) {
        while (right < c.length && c[right] !== ' ') {
            right++;
        }

        reverseWord(left, right - 1, c);
        left = right + 1;
        right = left;
    }

    return c.join('');
};

function reverseWord(left, right, c) {
    while (left < right) {
        [c[left], c[right]] = [c[right], c[left]];
        left++;
        right--;
    }
}
 */