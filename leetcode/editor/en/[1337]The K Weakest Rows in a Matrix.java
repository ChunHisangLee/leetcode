1337
        The K Weakest Rows in a Matrix
        2022-12-19 11:01:03

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < mat.length; i++) {
            int count = binarySearch(mat[i]);
            if (!map.containsKey(count)) {
                map.put(count, new ArrayList<>());
            }
            map.get(count).add(i);
        }
        int[] res = new int[k];
        int i = 0;
        for (int key : map.keySet()) {
            for (int index : map.get(key)) {
                res[i] = index;
                i++;
                if (i == k) {
                    break;
                }
            }
            if (i == k) {
                break;
            }
        }
        return res;
    }

    private int binarySearch(int[] row) {
        int left = 0;
        int right = 0;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (row[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
