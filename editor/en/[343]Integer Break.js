//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} n
 * @return {number}
 */
var integerBreak = function (n) {
    if (n <= 3) {
        return n - 1;
    }

    let result = 1;

    while (n > 4) {
        n -= 3;
        result *= 3;
    }

    return result * n;
};
//leetcode submit region end(Prohibit modification and deletion)
/*
var integerBreak = function (n) {
    if (n <= 3) {
        return n - 1;
    }

    if (n % 3 == 0) {
        return Math.pow(3, n / 3);
    }

    if (n % 3 == 1) {
        return 4 * Math.pow(3, (n - 4) / 3);
    }

    return 2 * Math.pow(3, (n - 2) / 3);
};
 */