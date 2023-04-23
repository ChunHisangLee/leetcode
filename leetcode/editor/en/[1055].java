1055
        Shortest Way to Form String
        2023-03-08 11:55:39

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestWay(String source, String target) {
        int n = source.lengh();
        int[][] arr = new int[n][26];
        Arrays.fill(arr[n - 1], -1);
        arr[n - 1][source.charAt(n - 1) - 'a'] = n - 1;
        for (int i = n - 2; i >= 0; ) {
            for (
                    int j = 0;
                    j < 26; j++) {
                arr[i][j] = arr[i + 1][j];
            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
