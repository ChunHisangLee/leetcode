//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s1
 * @param {string} s2
 * @param {string} s3
 * @return {boolean}
 */
var isInterleave = function (s1, s2, s3) {
    let m = s1.length;
    let n = s2.length;
    if (s3.length !== m + n) {
        return false;
    }
    let dp = new Array(m + 1);
    for (let i = 0; i <= m; i++) {
        dp[i] = new Array(n + 1);
    }
    dp[0][0] = true;
    for (let i = 0; i <= m; i++) {
        for (let j = 0; j <= n; j++) {
            if (i === 0 && j === 0) {
                continue;
            }
            if (i === 0) {
                dp[i][j] = dp[i][j - 1] && s2[j - 1] === s3[i + j - 1];
            } else if (j === 0) {
                dp[i][j] = dp[i - 1][j] && s1[i - 1] === s3[i + j - 1];
            } else {
                dp[i][j] = (dp[i][j - 1] && s2[j - 1] === s3[i + j - 1]) || (dp[i - 1][j] && s1[i - 1] === s3[i + j - 1]);
            }
        }
    }
    return dp[m][n];
};

//leetcode submit region end(Prohibit modification and deletion)
/*
var isInterleave = function (s1, s2, s3) {
    let m = s1.length;
    let n = s2.length;
    if (s3.length !== m + n) {
        return false;
    }
    let dp = new Array(m + 1);
    for (let i = 0; i <= m; i++) {
        dp[i] = new Array(n + 1);
    }
    for (let i = 0; i <= m; i++) {
        for (let j = 0; j <= n; j++) {
            if (i === 0 && j === 0) {
                dp[i][j] = true;
            } else if (i === 0) {
                dp[i][j] = dp[i][j - 1] && s2[j - 1] === s3[i + j - 1];
            } else if (j === 0) {
                dp[i][j] = dp[i - 1][j] && s1[i - 1] === s3[i + j - 1];
            } else {
                dp[i][j] = (dp[i][j - 1] && s2[j - 1] === s3[i + j - 1]) || (dp[i - 1][j] && s1[i - 1] === s3[i + j - 1]);
            }
        }
    }
    return dp[m][n];
};


var isInterleave = function (s1, s2, s3) {
    let m = s1.length;
    let n = s2.length;
    if (s3.length !== m + n) {
        return false;
    }
    let dp = new Array(m + 1);
    for (let i = 0; i <= m; i++) {
        dp[i] = new Array(n + 1).fill(false);
    }
    dp[0][0] = true;
    for (let i = 0; i <= m; i++) {
        for (let j = 0; j <= n; j++) {
            if (i > 0 && s1[i - 1] === s3[i + j - 1]) {
                dp[i][j] = dp[i][j] || dp[i - 1][j];
            }
            if (j > 0 && s2[j - 1] === s3[i + j - 1]) {
                dp[i][j] = dp[i][j] || dp[i][j - 1];
            }
        }
    }
    return dp[m][n];
};
 */