//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @return {number}
 */
var maxDepth = function(s) {
    let current=0;
    let max=0;

    for (let c of s){
        if(c=='('){
            current++;
            max=Math.max(max,current);
        }else if(c==')'){
            current--;
        }
    }

    return max;
};
//leetcode submit region end(Prohibit modification and deletion)
