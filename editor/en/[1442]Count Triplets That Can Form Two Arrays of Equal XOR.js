//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} arr
 * @return {number}
 */
var countTriplets = function (arr) {
    const n = arr.length;
    let prefix = [arr[0]];
    let count = 0;

    for (let i = 0; i < n; i++) {
        prefix.push(prefix[i] ^ arr[i]);
    }

    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            if (prefix[i] === prefix[j + 1]) {
                count += (j - i);
            }
        }
    }

    return count;
};
//leetcode submit region end(Prohibit modification and deletion)
