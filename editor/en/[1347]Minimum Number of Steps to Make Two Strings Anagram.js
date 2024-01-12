//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var minSteps = function (s, t) {
    const getCount = (s) => {
        let arr = new Array(26).fill(0);
        for (const c of s) {
            arr[c.charCodeAt(0) - 'a'.charCodeAt(0)]++;
        }

        return arr;
    }

    let countS = getCount(s);
    let countT = getCount(t);
    let count = 0;

    for (let i = 0; i < countS.length; i++) {
        if (countS[i] > countT[i]) {
            count += countS[i] - countT[i];
        }
    }

    return count;
};
//leetcode submit region end(Prohibit modification and deletion)
