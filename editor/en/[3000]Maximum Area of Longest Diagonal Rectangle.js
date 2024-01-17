//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[][]} dimensions
 * @return {number}
 */
var areaOfMaxDiagonal = function (dimensions) {
    let maxDiagonal = 0;
    let maxArea = 0;

    for (const [length, width] of dimensions) {
        const diagonal = Math.sqrt(length * length + width * width);
        const area = length * width;

        if (diagonal > maxDiagonal || diagonal === maxDiagonal && area > maxArea) {
            maxDiagonal = diagonal;
            maxArea = area;
        }
    }

    return maxArea;
};
//leetcode submit region end(Prohibit modification and deletion)
