
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int[] diff = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = reward1[i] - reward2[i];
            res += reward2[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < k; i++) {
            res += diff[n - 1 - i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
