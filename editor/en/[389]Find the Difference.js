//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 */
var findTheDifference = function (s, t) {
    let arr = {};

    for (const c of t) {
        arr[c] ? arr[c]++ : arr[c] = 1;
    }

    for (const c of s) {
        arr[c]--;
    }

    for (const c in arr) {
        if (arr[c] !== 0) {
            return c;
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)
/*
faster a bit.

var findTheDifference = function (s, t) {
    let arr = {};

    for (const c of t) {
        arr[c] ? arr[c]++ : arr[c] = 1;
    }

    for (const c of s) {
        arr[c]--;
    }

    for (const c in arr) {
        if (arr[c] !== 0) {
            return c;
        }
    }
};

var findTheDifference = function (s, t) {
    let arr = new Array(26).fill(0);

    for (const c of t) {
        arr[c.charCodeAt() - 'a'.charCodeAt()]++;
    }

    for (const c of s) {
        arr[c.charCodeAt() - 'a'.charCodeAt()]--;
    }

    for (let i = 0; i < 26; i++) {
        if (arr[i] !== 0) {
            return String.fromCharCode(i + 'a'.charCodeAt());
        }
    }
};
 */