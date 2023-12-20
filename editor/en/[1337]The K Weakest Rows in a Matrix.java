1337
        The K Weakest Rows in a Matrix
        2022-12-19 11:01:03

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]));
        int[] result = new int[k];

        for (int i = 0; i < mat.length; i++) {
            int count = getCount(mat[i]);

            pq.add(new int[]{i, count});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            int[] curr = pq.poll();
            result[i] = curr[0];
        }

        return result;
    }

    private int getCount(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (arr[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
