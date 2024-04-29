//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} source
 * @param {number} destination
 * @return {boolean}
 */
var validPath = function (n, edges, source, destination) {
    const uf = new UnionFind(n);

    for (const edge of edges) {
        uf.union(edge[0], edge[1]);
    }

    return uf.isConnected(source, destination);
};

class UnionFind {
    constructor(size) {
        this.parent = new Array(size);
        this.rank = new Array(size);

        for (let i = 0; i < size; i++) {
            this.parent[i] = i;
            this.rank[i] = 0;
        }
    }

    find(x) {
        if (this.parent[x] !== x) {
            this.parent[x] = this.find(this.parent[x]);
        }

        return this.parent[x];
    }

    union(x, y) {
        let rootX = this.find(x);
        let rootY = this.find(y);

        if (rootX !== rootY) {
            if (this.rank[rootX] < this.rank[rootY]) {
                this.rank[rootX] = rootY;
            } else if (this.rank[rootX] > this.rank[rootY]) {
                this.parent[rootY] = rootX;
            } else {
                this.parent[rootX] = rootY;
                this.rank[rootX]++;
            }
        }
    }

    isConnected(x, y) {
        return this.find(x) === this.find(y);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
