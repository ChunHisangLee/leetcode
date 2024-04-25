//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var longestIdealString = function (s, k) {
    let dp = Array(128).fill(0);
    const n = s.length;
    let maxLength = 0;

    for (let i = 0; i < n; i++) {
        const c = s.charCodeAt(i);
        let maxLengthForC = 0;
        const start = Math.max('a'.charCodeAt(0), c - k);
        const end = Math.min('z'.charCodeAt(0), c + k);

        for (let d = start; d <= end; d++) {
            maxLengthForC = Math.max(maxLengthForC, dp[d]);
        }

        dp[c] = maxLengthForC + 1;
        maxLength = Math.max(maxLength, dp[c]);
    }

    return maxLength;
};
//leetcode submit region end(Prohibit modification and deletion)
