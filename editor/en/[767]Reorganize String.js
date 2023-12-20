//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {string}
 */
var reorganizeString = function (s) {
    let map = new Map();
    let max = 0;
    let maxChar = '';
    for (let i = 0; i < s.length; i++) {
        let char = s[i];
        let count = map.get(char) || 0;
        count++;
        map.set(char, count);
        if (count > max) {
            max = count;
            maxChar = char;
        }
    }
    if (max > (s.length + 1) / 2) {
        return '';
    }
    let res = new Array(s.length);
    let index = 0;
    while (map.get(maxChar) > 0) {
        res[index] = maxChar;
        index += 2;
        let count = map.get(maxChar);
        count--;
        map.set(maxChar, count);
    }
    map.delete(maxChar);
    for (let [key, value] of map) {
        while (value > 0) {
            if (index >= res.length) {
                index = 1;
            }
            res[index] = key;
            index += 2;
            value--;
        }
    }
    return res.join('');
};
//leetcode submit region end(Prohibit modification and deletion)
