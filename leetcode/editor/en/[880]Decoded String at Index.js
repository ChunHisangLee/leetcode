//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var decodeAtIndex = function (s, k) {
    let size = BigInt(0);

    for (const c of s) {
        if (!isNaN(c)) {
            size *= BigInt(c);
        } else {
            size++;
        }
    }

    k = BigInt(k);

    for (let i = s.length - 1; i >= 0; i--) {
        const c = s[i];
        k %= size;

        if (!isNaN(c)) {
            size /= BigInt(c);
        } else {
            if (k === BigInt(0) || k === size) {
                return c;
            }

            size--;
        }
    }
    return "";
};
//leetcode submit region end(Prohibit modification and deletion)
/*
var decodeAtIndex = function (s, k) {
    let size = 0;
    let i = 0;

    while (size < k) {
        if (!isNaN(s[i])) {
            size *= Number(s[i]);
        } else {
            size++;
        }

        i++;
    }

    for (let j = i - 1; j >= 0; j--) {
        k %= size;
        if (!isNaN(s[j])) {
            size /= Number(s[j]);
        } else {
            if (k === 0 || k === size) {
                return s[j];
            }

            size--;
        }
    }
};
 */