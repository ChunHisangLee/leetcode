
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        int countFirst = getCount(s.substring(0, mid));
        int countSecond = getCount(s.substring(mid));
        return countFirst == countSecond;
    }

    private int getCount(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
