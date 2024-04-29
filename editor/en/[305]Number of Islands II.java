//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind uf = new UnionFind(m * n);
        List<Integer> result = new ArrayList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] pos : positions) {
            int row = pos[0];
            int col = pos[1];
            int index = row * n + col;

            if (uf.parent[index] != -1) {
                result.add(uf.getCount());
                continue;
            }

            uf.addLand(index);

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                int neighborIndex = newRow * n + newCol;

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && uf.parent[neighborIndex] != -1) {
                    uf.union(index, neighborIndex);
                }
            }

            result.add(uf.getCount());
        }

        return result;
    }

    class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(int size) {
            parent = new int[size];
            Arrays.fill(parent, -1);
            count = 0;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                count--;
            }
        }

        public void addLand(int x) {
            if (parent[x] == -1) {
                parent[x] = x;
                count++;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int[] arr = new int[m * n];
        Arrays.fill(arr, -1);
        for (int[] point : positions) {
            int node = point[0] * n + point[1];
            if (arr[node] != -1) {
                list.add(count);
                continue;
            }
            arr[node] = node;
            count++;
            for (int[] dir : dirs) {
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && arr[x * n + y] != -1) {
                    int node1 = find(arr, node);
                    int node2 = find(arr, x * n + y);
                    if (node1 != node2) {
                        arr[node1] = node2;
                        count--;
                    }
                }
            }
            list.add(count);
        }
        return list;
    }

    private int find(int[] arr, int x) {
        return arr[x] == x ? x : (arr[x] = find(arr, arr[x]));
    }
}
 */