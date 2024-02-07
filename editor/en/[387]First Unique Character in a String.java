//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        final int NOT_FOUND = -1;
        int result = Integer.MAX_VALUE;

        for (char c = 'a'; c <= 'z'; c++) {
            if (isUnique(c, s)) {
                int index = s.indexOf(c);
                result = Math.min(result, index);
            }
        }

        return result == Integer.MAX_VALUE ? NOT_FOUND : result;
    }

    private boolean isUnique(char c, String s) {
        int index = s.indexOf(c);
        return index != -1 && index == s.lastIndexOf(c);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
