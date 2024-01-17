//leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * function BinaryMatrix() {
 *     @param {integer} row, col
 *     @return {integer}
 *     this.get = function(row, col) {
 *         ...
 *     };
 *
 *     @return {[integer, integer]}
 *     this.dimensions = function() {
 *         ...
 *     };
 * };
 */

/**
 * @param {BinaryMatrix} binaryMatrix
 * @return {number}
 */
var leftMostColumnWithOne = function (binaryMatrix) {
    const dimensions = binaryMatrix.dimensions();
    const row = dimensions[0];
    const col = dimensions[1];
    let currRow = 0;
    let currCol = col - 1;
    let result = -1;

    while (currRow < row && currCol >= 0) {
        if (binaryMatrix.get(currRow, currCol) === 1) {
            result = currCol;
            currCol--;
        } else {
            currRow++;
        }
    }

    return result;
};
//leetcode submit region end(Prohibit modification and deletion)
