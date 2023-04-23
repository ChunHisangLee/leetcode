944
        Delete Columns to Make Sorted
        2023-01-03 09:22:39

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        for (int col = 0; col < strs[0].length(); col++) {
            for (int row = 1; row < strs.length; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
