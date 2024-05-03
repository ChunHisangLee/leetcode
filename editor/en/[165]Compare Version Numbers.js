//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function (version1, version2) {
    const v1 = version1.split('.');
    const v2 = version2.split('.');
    const length = Math.max(v1.length, v2.length);

    for (let i = 0; i < length; i++) {
        const num1 = i < v1.length ? parseInt(v1[i], 10) : 0;
        const num2 = i < v2.length ? parseInt(v2[i], 10) : 0;

        if (num1 !== num2) {
            return num1 > num2 ? 1 : -1;
        }
    }

    return 0;
};
//leetcode submit region end(Prohibit modification and deletion)
