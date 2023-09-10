//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} n
 * @return {number}
 */
var countOrders = function (n) {
    const MOD = 1e9 + 7;
    let res = 1;
    for (let i = 1; i <= n; i++) {
        res = (res * i * (2 * i - 1)) % MOD;
    }
    return res;
};
//leetcode submit region end(Prohibit modification and deletion)

/*
- 82 ms
var countOrders = function (n) {
    const MOD = 1e9 + 7;
    let dp = Array.from({length: n + 1}, () => new Array(n + 1).fill(0));
    dp[0][0] = 1;
    for (let i = 0; i <= n; i++) {
        for (let j = i; j <= n; j++) {
            if (i > 0) {
                dp[i][j] += i * dp[i - 1][j];
            }
            if (j > i) {
                dp[i][j] += (j - i) * dp[i][j - 1];
            }
            dp[i][j] %= MOD;
        }
    }
    return dp[n][n];
};

- 108 ms
var countOrders = function (n) {
    const MOD = 1e9 + 7;
    let dp = Array.from({length: n + 1}, () => new Array(n + 1).fill(0));
    return dyP(n, n);

    function dyP(uPicked, uDelivered) {
        if (uPicked === 0 && uDelivered === 0) {
            return 1;
        }
        if (uPicked < 0 || uDelivered < 0 || uDelivered < uPicked) {
            return 0;
        }
        if (dp[uPicked][uDelivered] != 0) {
            return dp[uPicked][uDelivered];
        }
        let res = 0;
        res += (uPicked * dyP(uPicked - 1, uDelivered) + (uDelivered - uPicked) * dyP(uPicked, uDelivered - 1));
        res %= MOD;
        return dp[uPicked][uDelivered] = res;
    }
};
 */