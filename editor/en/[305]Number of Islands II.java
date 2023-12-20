305 Number of Islands II 2022-12-20 11:20:52

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] arr;
    int count;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<Integer> list = new ArrayList<>();
        count = 0;
        arr = new int[m * n];
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
                    union(node, x * n + y);
                }
            }
            list.add(count);
        }
        return list;
    }

    private int find(int x) {
        return arr[x] == x ? x : (arr[x] = find(arr[x]));
    }

    private void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            arr[x] = y;
            count--;
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