//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} people
 * @param {number} limit
 * @return {number}
 */
var numRescueBoats = function (people, limit) {
    people.sort((a, b) => a - b);
    let left = 0;
    let right = people.length - 1;
    let result = 0;

    while (left <= right) {
        if (people[left] + people[right] <= limit) {
            left++;
        }

        result++;
        right--;
    }

    return result;
};
//leetcode submit region end(Prohibit modification and deletion)
