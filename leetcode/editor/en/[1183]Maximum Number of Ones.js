//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} width
 * @param {number} height
 * @param {number} sideLength
 * @param {number} maxOnes
 * @return {number}
 */
var maximumNumberOfOnes = function (width, height, sideLength, maxOnes) {
    let arr = new Array(sideLength * sideLength).fill(0);
    for (let i = 0; i < height; i++) {
        let row = i % sideLength;
        for (let j = 0; j < width; j++) {
            let col = j % sideLength;
            arr[(row * sideLength) + col]++;
        }
    }
    arr.sort((a, b) => b - a);
    let res = 0;
    for (let i = 0; i < maxOnes; i++) {
        res += arr[i];
    }
    return res;
};
//leetcode submit region end(Prohibit modification and deletion)
