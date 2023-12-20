
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long sumScores(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] arr = new int[n];
        int left = 0;
        int right = 0;
        for (int i = 1; i < n; i++) {
            if (i < right) {
                arr[i] = Math.min(arr[i - left], right - i);
            }
            while (i + arr[i] < n && c[arr[i]] == c[i + arr[i]]) {
                arr[i]++;
            }
            if (i + arr[i] > right) {
                left = i;
                right = i + arr[i];
            }
        }
        long res = n;
        for (int num : arr) {
            res += num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
