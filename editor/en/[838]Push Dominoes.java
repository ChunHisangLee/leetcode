

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String pushDominoes(String dominoes) {
        char[] chDom = dominoes.toCharArray();
        int n = chDom.length;
        int[] arr = new int[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (chDom[i] == 'R') {
                num = n;
            } else if (chDom[i] == 'L') {
                num = 0;
            } else {
                num = Math.max(num - 1, 0);
            }
            arr[i] += num;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (chDom[i] == 'L') {
                num = n;
            } else if (chDom[i] == 'R') {
                num = 0;
            } else {
                num = Math.max(num - 1, 0);
            }
            arr[i] -= num;
        }
        StringBuilder sb = new StringBuilder();
        for (int item : arr) {
            if (item > 0) {
                sb.append('R');
            } else if (item < 0) {
                sb.append('L');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
