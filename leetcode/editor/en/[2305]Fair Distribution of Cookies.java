
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int res = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        backtrack(cookies, k, new int[k], 0);
        return res;
    }

    private void backtrack(int[] cookies, int target, int[] arr, int index) {
        if (index == cookies.length) {
            int max = 0;
            for (int num : arr) {
                max = Math.max(max, num);
            }
            res = Math.min(res, max);
            return;
        }
        for (int i = 0; i < target; i++) {
            arr[i] += cookies[index];
            backtrack(cookies, target, arr, index + 1);
            arr[i] -= cookies[index];
            if (arr[i] == 0) {
                break;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
