//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function (s) {
    let res = 0;
    let num = 0;
    let temp = 0;
    for (let i = s.length - 1; i >= 0; i--) {
        switch (s.charAt(i)) {
            case 'I':
                num = 1;
                break;
            case 'V':
                num = 5;
                break;
            case 'X':
                num = 10;
                break;
            case 'L':
                num = 50;
                break;
            case 'C':
                num = 100;
                break;
            case 'D':
                num = 500;
                break;
            case 'M':
                num = 1000;
                break;
        }
        if (num < temp) {
            res -= num;
        } else {
            res += num;
        }
        temp = num;
    }
    return res;
};
//leetcode submit region end(Prohibit modification and deletion)
