

//leetcode submit region begin(Prohibit modification and deletion)
class UnionFind {
    private final int n;
    private final int[] group;
    public int count;

    UnionFind(int n) {
        this.n = n;
        group = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
    }

    public boolean union(int i, int j) {
        int x = find(i);
        int y = find(j);

        if (y != j || x == y) {
            return false;
        }

        count--;
        group[y] = x;
        return true;
    }

    private int find(int x) {
        if (group[x] != x) {
            group[x] = find(group[x]);
        }

        return group[x];
    }
}

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf = new UnionFind(n);
        for (int node = 0; node < n; node++) {
            int[] children = {leftChild[node], rightChild[node]};
            for (int j : children) {
                if (j == -1) {
                    continue;
                }

                if (!uf.union(node, j)) {
                    return false;
                }
            }
        }

        return uf.count == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
BFS

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];
        int root = -1;
        boolean[] isVisited = new boolean[n];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                inDegree[leftChild[i]]++;
            }

            if (rightChild[i] != -1) {
                inDegree[rightChild[i]]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (root == -1) {
                    root = i;
                } else {
                    return false;
                }
            }
        }

        if (root == -1) {
            return false;
        }

        deque.offer(root);

        while (!deque.isEmpty()) {
            int curr = deque.poll();

            if (isVisited[curr]) {
                return false;
            }

            isVisited[curr] = true;

            if (leftChild[curr] != -1) {
                deque.offer(leftChild[curr]);
            }

            if (rightChild[curr] != -1) {
                deque.offer(rightChild[curr]);
            }
        }

        int count = 0;

        for (boolean item : isVisited) {
            if (item) {
                count++;
            }
        }

        return count == n;
    }
}
 */