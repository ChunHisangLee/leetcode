
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int res = 0;

    public int maximumRequests(int n, int[][] requests) {
        backtrack(requests, new int[n], 0, 0);
        return res;
    }

    private void backtrack(int[][] requests, int[] inDegree, int index, int count) {
        if (index == requests.length) {
            for (int num : inDegree) {
                if (num != 0) {
                    return;
                }
            }
            res = Math.max(res, count);
            return;
        }
        int x = requests[index][0];
        int y = requests[index][1];
        inDegree[x]--;
        inDegree[y]++;
        backtrack(requests, inDegree, index + 1, count + 1);
        inDegree[x]++;
        inDegree[y]--;
        backtrack(requests, inDegree, index + 1, count);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
