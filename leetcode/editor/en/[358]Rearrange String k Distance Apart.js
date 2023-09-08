/**
 Given a string s and an integer k, rearrange s such that the same characters
 are at least distance k from each other. If it is not possible to rearrange the
 string, return an empty string "".


 Example 1:


 Input: s = "aabbcc", k = 3
 Output: "abcabc"
 Explanation: The same letters are at least a distance of 3 from each other.


 Example 2:


 Input: s = "aaabc", k = 3
 Output: ""
 Explanation: It is not possible to rearrange the string.


 Example 3:


 Input: s = "aaadbbcc", k = 2
 Output: "abacabcd"
 Explanation: The same letters are at least a distance of 2 from each other.



 Constraints:


 1 <= s.length <= 3 * 10⁵
 s consists of only lowercase English letters.
 0 <= k <= s.length


 Related Topics Hash Table String Greedy Sorting Heap (Priority Queue) Counting
 👍 884 👎 37

 */

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var rearrangeString = function (s, k) {
    if (k <= 1) {
        return s;
    }
    const map = new Map();
    for (const c of s) {
        map.set(c, (map.get(c) || 0) + 1);
    }
    const maxHeap = Array.from(map.entries()).sort((a, b) => b[1] - a[1]);
    const res = [];
    const waitQueue = [];
    while (maxHeap.length > 0) {
        const curr = maxHeap.shift();
        res.push(curr[0]);
        curr[1]--;
        waitQueue.push(curr);
        if (waitQueue.length < k) {
            continue;
        }
        const front = waitQueue.shift();
        if (front[1] > 0) {
            maxHeap.push(front);
            maxHeap.sort((a, b) => b[1] - a[1]);
        }
    }
    return res.length === s.length ? res.join('') : '';
};
//leetcode submit region end(Prohibit modification and deletion)
