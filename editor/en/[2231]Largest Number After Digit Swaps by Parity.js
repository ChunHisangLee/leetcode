//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} num
 * @return {number}
 */
var largestInteger = function (num) {
    let odd = new MinPriorityQueue();
    let even = new MinPriorityQueue();
    let reference = num;
    let multiply = 1;
    let result = 0;

    while (num > 0) {
        const temp = num % 10;
        if (temp % 2 === 1) {
            odd.enqueue(temp);
        } else {
            even.enqueue(temp);
        }

        num = Math.floor(num / 10);
    }

    while (reference > 0) {
        const temp = reference % 10;

        if (temp % 2 === 1) {
            result = odd.dequeue().element * multiply + result;
        } else {
            result = even.dequeue().element * multiply + result;
        }

        reference = Math.floor(reference / 10);
        multiply *= 10;
    }

    return result;
};
//leetcode submit region end(Prohibit modification and deletion)
