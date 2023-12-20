//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[][]} maze
 * @param {number[]} start
 * @param {number[]} destination
 * @return {boolean}
 */
var hasPath = function (maze, start, destination) {
        let m = maze.length;
        let n = maze[0].length;
        let dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]];
        let dq = [start];
        maze[start[0]][start[1]] = -1;
        while (dq.length) {
            let curr = dq.shift();
            if (curr[0] === destination[0] && curr[1] === destination[1]) {
                return true;
            }
            for (let dir of dirs) {
                let x = curr[0] + dir[0];
                let y = curr[1] + dir[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] !== 1) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (maze[x][y] !== -1) {
                    maze[x][y] = -1;
                    dq.push([x, y]);
                }
            }
        }
        return false;
    }
;
//leetcode submit region end(Prohibit modification and deletion)
