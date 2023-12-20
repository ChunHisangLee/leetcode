//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string[][]} tickets
 * @return {string[]}
 */
var findItinerary = function (tickets) {
    let map = {};
    let list = [];

    for (let [src, dst] of tickets) {
        if (!map[src]) {
            map[src] = [];
        }
        map[src].push(dst);
    }
    for (let loc in map) {
        map[loc].sort();
    }

    function dfs(node) {
        let des = map[node];
        while (des && des.length > 0) {
            dfs(des.shift());
        }
        list.push(node);
    }

    dfs("JFK");
    return list.reverse();
};
//leetcode submit region end(Prohibit modification and deletion)
