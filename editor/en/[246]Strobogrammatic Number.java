
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStrobogrammatic(String num) {
        int[] arr = new int[]{0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        char[] c = num.toCharArray();

        for (int left = 0, right = c.length - 1; left <= right; left++, right--) {
            if (arr[c[left] - '0'] != c[right] - '0') {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
