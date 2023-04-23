// 844
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int pos1 = s.length() - 1;
        int pos2 = t.length() - 1;
        while (pos1 >= 0 || pos2 >= 0) {
            pos1 = getPosition(s, pos1);
            pos2 = getPosition(t, pos2);
            if (pos1 >= 0 && pos2 >= 0 && s.charAt(pos1) == t.charAt(pos2)) {
                pos1--;
                pos2--;
            } else {
                return pos1 == -1 && pos2 == -1;
            }
        }
        return true;
    }

    private int getPosition(String str, int curPos) {
        int backPos = 0;
        while (curPos >= 0 && (backPos > 0 || str.charAt(curPos) == '#')) {
            if (str.charAt(curPos) == '#')
                backPos++;
            else
                backPos--;
            curPos--;
        }
        return curPos;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
